package com.androidavancado.posiot.sensorperigo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public interface IKnotServiceConnection {
    void subscribe(String deviceUUID, OnDataChangedListener listener);
    void unsubscribe();

}
