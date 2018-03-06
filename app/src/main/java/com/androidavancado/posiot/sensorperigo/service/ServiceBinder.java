package com.androidavancado.posiot.sensorperigo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class ServiceBinder extends Binder {

    private IKnotServiceConnection mBinder;

    public ServiceBinder(IKnotServiceConnection s) {
        mBinder = s;
    }

    public IKnotServiceConnection getService() {
        return mBinder;
    }




}
