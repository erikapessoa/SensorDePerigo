package com.androidavancado.posiot.sensorperigo.model;

/**
 * Created by erika on 25/02/18.
 */

public class Contact {

    private String mName;
    private String mEmail;
    private Phone mCellPhone;

    /**
     * Nome do contato, e-mail e número do celular.
     *
     * @param mName
     * @param mEmail
     * @param mCellPhone
     */
    public Contact(String mName, String mEmail, Phone mCellPhone) {
        this.mName = mName;
        this.mEmail = mEmail;
        this.mCellPhone = mCellPhone;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public Phone getmCellPhone() {
        return mCellPhone;
    }

    public void setmCellPhone(Phone mCellPhone) {
        this.mCellPhone = mCellPhone;
    }
}
