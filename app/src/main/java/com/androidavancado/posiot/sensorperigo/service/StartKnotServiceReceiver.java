package com.androidavancado.posiot.sensorperigo.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.IBinder;

import com.androidavancado.posiot.sensorperigo.App;
import com.androidavancado.posiot.sensorperigo.model.ButtonData;
import com.androidavancado.posiot.sensorperigo.util.Constants;

import java.util.List;

import static android.content.Context.BIND_AUTO_CREATE;

public class StartKnotServiceReceiver extends BroadcastReceiver {

    private IKnotServiceConnection mKnotServiceConnection;
    final Context contx = App.getContext();
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving

        String verifyEmail, verifyPassword;

        //Verificar se o usuário já existe, iniciar o serviço no broadcast
        SharedPreferences sensorPerigoPreferences = App.getContext().getSharedPreferences(Constants.SENSOR_PERIGO_PREF, contx.MODE_PRIVATE);
        verifyEmail = sensorPerigoPreferences.getString("email", "");
        verifyPassword = sensorPerigoPreferences.getString("senha", "");
        if (!verifyEmail.isEmpty() && !verifyPassword.isEmpty()) {
            Intent it = new Intent(context, KnotIntegrationService.class);
            context.startService(it);
            //context.bindService(it, this, BIND_AUTO_CREATE);
        }

    }

    /*
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder service) {

        mKnotServiceConnection = ((ServiceBinder) service).getService();

        //mKnotServiceConnection.subscribe(getIntent().getStringExtra(Constants.EXTRA_DEVICE_UUID), SendSMS.this);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        mKnotServiceConnection = null;
    }

    @Override
    public void onDataChanged(List<ButtonData> deviceData) {

    }

    */
}
