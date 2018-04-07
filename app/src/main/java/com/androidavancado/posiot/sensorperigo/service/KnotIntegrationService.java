package com.androidavancado.posiot.sensorperigo.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.androidavancado.posiot.sensorperigo.model.ButtonData;
import com.androidavancado.posiot.sensorperigo.model.ButtonDevice;
import com.androidavancado.posiot.sensorperigo.util.Constants;
import com.androidavancado.posiot.sensorperigo.util.Logger;
import com.androidavancado.posiot.sensorperigo.util.PoolingTimer;

import java.util.List;

import br.org.cesar.knot.lib.connection.FacadeConnection;
import br.org.cesar.knot.lib.exception.InvalidDeviceOwnerStateException;
import br.org.cesar.knot.lib.exception.KnotException;
import br.org.cesar.knot.lib.model.KnotList;
import br.org.cesar.knot.lib.model.KnotQueryData;

public class KnotIntegrationService extends Service implements IKnotServiceConnection, OnDataChangedListener, ServiceConnection {

    private OnDataChangedListener mListener;

    private PoolingTimer poolingTimer;

    private String deviceUUID;

    private List<ButtonData> deviceData;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new ServiceBinder(this);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        unsubscribe();
        return super.onUnbind(intent);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logger.d("ENTREI EM KnotIntegrationService método onStartCommand");

        super.onStartCommand(intent, flags, startId);
        bindService(intent, this, BIND_AUTO_CREATE);
        return START_STICKY;
    }


    @Override
    public void subscribe(String deviceUUID, OnDataChangedListener listener) {

        Logger.d("ENTREI EM KnotIntegrationService método subscribe");

        mListener = listener;

        this.deviceUUID = deviceUUID;

        //start pooling
        syncAndStartPooling();
    }

    @Override
    public void unsubscribe() {
        mListener = null;

        //stop pooling
        if (poolingTimer != null) {
            poolingTimer.stopPooling();
        }

        stopSelf();
    }


    private void notifyListener(List<ButtonData> deviceData){

        Logger.d("ENTREI EM KnotIntegrationService método notifyListener");

        if(mListener != null) {
            mListener.onDataChanged(deviceData);

        }
    }


    @Override
    public void onDataChanged(List<ButtonData> deviceData) {


        //// ESSE CÓDIGO AQUI É APENAS PRA TESTAR SE ELE TÁ RECEBENDO A MUDANÇA DE ESTADO DO BOTÃO
        //// PRECISA DESCOMENTAR A PARTE DE ENVIAR SMS
        Logger.d("ENTREI EM KnotIntegrationService método onDataChanged");

        if (deviceData != null) {
            ButtonData button = deviceData.get(0);

            Logger.d("Valor do botão = " + button.getMCurrentValue());


            //CASO O VALOR DO BOTÃO SEJA TRUE SIGNIFICA QUE UM PEDIDO DE SOCORRO FOI FEITO, então
            //tenta enviar o SMS

            /*

            if(button.getMCurrentValue()) {
                SendSMS.sendSMS();
            }

            */
        }

    }



    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        subscribe(deviceUUID, KnotIntegrationService.this);

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        //mKnotServiceConnection = null;
    }

    /**
     *
     */
    private void syncAndStartPooling() {
        // Force a sync and reeschedule the last pooling
        if (poolingTimer != null) {
            poolingTimer.stopPooling();
            poolingTimer.startPooling();
        } else {
            this.poolingTimer = new PoolingTimer(poolingListener);
            poolingTimer.startPooling();
        }
        // Sync all data of devices
        syncData();
    }

    /**
     *
     */
    private void syncData() {
        new SyncDeviceDataTask().execute();
    }

    /**
     *
     */

    private PoolingTimer.PoolingListener poolingListener = new PoolingTimer.PoolingListener() {
        @Override
        public void onPoolingFinished() {
            syncData();
        }
    };



    private class SyncDeviceDataTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {

            List<ButtonDevice> mDevicesList = null;
            KnotList<ButtonDevice> list = new KnotList<>(ButtonDevice.class);
            KnotList<ButtonData> listOfData = new KnotList<>(ButtonData.class);
            KnotQueryData knotQueryData = new KnotQueryData();

            try {
                FacadeConnection.getInstance().setupHttp(Constants.KNOT_URL, Constants.DEFAULT_UUID,
                        Constants.DEFAULT_TOKEN);
                mDevicesList = FacadeConnection.getInstance().httpGetDeviceList(list);

                deviceUUID = mDevicesList.get(0).getUuid();

                deviceData = FacadeConnection.getInstance().httpGetDataList(deviceUUID, knotQueryData,listOfData);

            } catch (KnotException e) {
                e.printStackTrace();
            } catch (InvalidDeviceOwnerStateException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            if (deviceData != null && deviceData.size() > 0) {
                for (ButtonData data : deviceData){
                    notifyListener(deviceData);
                }
            }
        }

    }

}
