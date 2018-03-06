package com.androidavancado.posiot.sensorperigo.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;
import android.util.Log;

import com.androidavancado.posiot.sensorperigo.model.ButtonData;
import com.androidavancado.posiot.sensorperigo.util.PoolingTimer;
import com.androidavancado.posiot.sensorperigo.util.Util;

import java.util.List;
import java.util.Locale;

import br.org.cesar.knot.lib.connection.FacadeConnection;
import br.org.cesar.knot.lib.exception.InvalidDeviceOwnerStateException;
import br.org.cesar.knot.lib.exception.KnotException;
import br.org.cesar.knot.lib.model.KnotList;
import br.org.cesar.knot.lib.model.KnotQueryData;

public class KnotIntegrationService extends Service implements IKnotServiceConnection{

    private OnDataChangedListener mListener;

    private PoolingTimer poolingTimer;

    private String deviceUUID;

    private List<ButtonData> deviceData;


    //##########################################

    private static final String TAG = "TESTEGPS";
    private LocationManager mLocationManager = null;
    private static final int LOCATION_INTERVAL = 1000;
    private static final float LOCATION_DISTANCE = 10f;

    Location mLastLocation;

    LocationListener[] mLocationListeners = new LocationListener[] {
            new LocationListener(LocationManager.GPS_PROVIDER),
            new LocationListener(LocationManager.NETWORK_PROVIDER)
    };

    //############################################

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new ServiceBinder(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

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

    private void syncData() {
        new SyncDeviceDataTask().execute();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        unsubscribe();
        return super.onUnbind(intent);
    }

    private PoolingTimer.PoolingListener poolingListener = new PoolingTimer.PoolingListener() {
        @Override
        public void onPoolingFinished() {
            syncData();
        }
    };

    @Override
    public void subscribe(String deviceUUID, OnDataChangedListener listener) {
        mListener = listener;

        this.deviceUUID = deviceUUID;

        //start pooling
        syncAndStartPooling();

    }


    private void notifyListener(List<ButtonData> deviceData){
        if(mListener != null) {
            mListener.onDataChanged(deviceData);

            initializeLocationManager();
            requestUpdate();

            double latitude = mLastLocation.getLatitude();
            double longitude = mLastLocation.getLongitude();

                SharedPreferences prefs = this.getSharedPreferences("ArquivoPreferencia", Context.MODE_PRIVATE);
                String nomeContato = prefs.getString("NOME_CONTATO", null);
                String foneContato = prefs.getString("FONE_CONTATO", null);

                String mensagem = Util.mensagem(nomeContato, latitude, longitude);

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(foneContato, null, mensagem, null, null);

        }
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


    private class SyncDeviceDataTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {

            KnotList<ButtonData> listOfData = new KnotList<>(ButtonData.class);
            KnotQueryData knotQueryData = new KnotQueryData();

            try {
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

    //##################################################
    // UTILIZADO PARA PEGAR A LOCALIZAÇÃO DO USUÁRIO
    private class LocationListener implements android.location.LocationListener
    {


        public LocationListener(String provider)
        {
            Log.e(TAG, "LocationListener " + provider);
            mLastLocation = new Location(provider);
        }

        @Override
        public void onLocationChanged(Location location)
        {
            Log.e(TAG, "onLocationChanged: " + location);
            mLastLocation.set(location);
        }

        @Override
        public void onProviderDisabled(String provider)
        {
            Log.e(TAG, "onProviderDisabled: " + provider);
        }

        @Override
        public void onProviderEnabled(String provider)
        {
            Log.e(TAG, "onProviderEnabled: " + provider);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras)
        {
            Log.e(TAG, "onStatusChanged: " + provider);
        }
    }

    private void initializeLocationManager() {
        Log.e(TAG, "initializeLocationManager");
        if (mLocationManager == null) {
            mLocationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        }
    }

    public void requestUpdate()
    {
        try {
            mLocationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER, LOCATION_INTERVAL, LOCATION_DISTANCE,
                    mLocationListeners[1]);
        } catch (java.lang.SecurityException ex) {
            Log.i(TAG, "fail to request location update, ignore", ex);
        } catch (IllegalArgumentException ex) {
            Log.d(TAG, "network provider does not exist, " + ex.getMessage());
        }

        try {
            mLocationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, LOCATION_INTERVAL, LOCATION_DISTANCE,
                    mLocationListeners[0]);
        } catch (java.lang.SecurityException ex) {
            Log.i(TAG, "fail to request location update, ignore", ex);
        } catch (IllegalArgumentException ex) {
            Log.d(TAG, "gps provider does not exist " + ex.getMessage());
        }
    }

    //##################################################






}
