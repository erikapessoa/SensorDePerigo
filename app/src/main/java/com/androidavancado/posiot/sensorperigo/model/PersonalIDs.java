package com.androidavancado.posiot.sensorperigo.model;

/**
 * Created by erika on 06/03/18.
 */

public class PersonalIDs {

    private long mRG;
    private long mCPF;

    public PersonalIDs(long mRG, long mCPF) {

        //Verificar formato de RG e CPF antes de inserir
        this.mRG = mRG;
        this.mCPF = mCPF;
    }

    public long getmRG() {
        return mRG;
    }

    public void setmRG(long rG) {
        this.mRG = rG;
    }

    public long getmCPF() {
        return mCPF;
    }

    public void setmCPF(long cPF) {
        this.mCPF = cPF;
    }
}
