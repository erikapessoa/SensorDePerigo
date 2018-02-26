package com.androidavancado.posiot.sensorperigo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class KnotIntegrationService extends Service {
    public KnotIntegrationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
