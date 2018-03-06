package com.androidavancado.posiot.sensorperigo.communication;


import java.text.ParseException;

/**
 * Created by erika on 25/02/18.
 */

public interface IKnotCommunication {

    /**
     * Get all devices of the specif owner
     */
    public void getAllDevices();


    /**
     * Get data information about device behavior
     */
    public void getDataByDevice() throws ParseException;


}
