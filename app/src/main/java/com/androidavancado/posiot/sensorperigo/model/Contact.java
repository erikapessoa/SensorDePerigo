package com.androidavancado.posiot.sensorperigo.model;

/**
 * Created by erika on 25/02/18.
 */

public class Contact {

    private String mName;
    private String mEmail;
    private CellPhone mCellPhone;

    /**
     * Nome do contato, e-mail e número do celular.
     *
     * @param mName
     * @param mEmail
     * @param mCellCellPhone
     */
    public Contact(String mName, String mEmail, CellPhone mCellCellPhone) {
        this.mName = mName;
        this.mEmail = mEmail;
        this.mCellPhone = mCellCellPhone;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String name) {
        this.mName = name;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String email) {
        this.mEmail = email;
    }

    public CellPhone getmCellPhone() {
        return mCellPhone;
    }

    public void setmCellPhone(CellPhone cellPhone) {
        this.mCellPhone = cellPhone;
    }
}
