package com.androidavancado.posiot.sensorperigo.service;

import com.androidavancado.posiot.sensorperigo.model.ButtonData;

import java.util.List;

/**
 * Created by erika on 25/02/18.
 */

public interface OnDataChangedListener {

    public void onDataChanged (List<ButtonData> deviceData);
}
