package com.androidavancado.posiot.sensorperigo.model;

import br.org.cesar.knot.lib.model.AbstractThingData;

/**
 * Created by erika on 25/02/18.
 */

public class ButtonData extends AbstractThingData {

    private String mUuid;
    private boolean mCurrentValue;

    public boolean getMCurrentValue() {
        if(data != null){

            Boolean b = (Boolean) data.value;
            return b;
        } else {
            return false;
        }
    }

    public String getButtonUUID() {
        return source;
    }

    public void setButtonUUID(String buttonUUID) {
        this.mUuid = buttonUUID;
    }

    public void setCurrentValue(boolean currentValue) {
        this.mCurrentValue = currentValue;
    }

    public void setData(boolean data){
        super.data.value = data;
    }

    public boolean getData(){
        return (Boolean)data.value;
    }

    @Override
    public String toString() {
        String value = super.toString() + " ButtonUUID = " + getButtonUUID() +
                " currentValue = " + getMCurrentValue();
        return value;
    }

}
