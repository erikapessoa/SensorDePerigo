package com.androidavancado.posiot.sensorperigo.model;

import java.util.Calendar;

/**
 * Created by erika on 06/03/18.
 */

public class PersonalIDs {

    private long mRG;
    private String mRG_mInstitutionEmitter;
    private String mRG_UF;
    private Calendar mRG_ExpeditionDate;
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

    public String getmRG_mInstitutionEmitter() {
        return mRG_mInstitutionEmitter;
    }

    public void setmRG_mInstitutionEmitter(String mRG_mInstitutionEmitter) {
        this.mRG_mInstitutionEmitter = mRG_mInstitutionEmitter;
    }

    public String getmRG_UF() {
        return mRG_UF;
    }

    public void setmRG_UF(String mRG_UF) {
        this.mRG_UF = mRG_UF;
    }

    public Calendar getmRG_ExpeditionDate() {
        return mRG_ExpeditionDate;
    }

    public void setmRG_ExpeditionDate(Calendar mRG_ExpeditionDate) {
        this.mRG_ExpeditionDate = mRG_ExpeditionDate;
    }
}
