package com.androidavancado.posiot.sensorperigo.model;

import java.net.PasswordAuthentication;
import java.util.Calendar;

/**
 *
 * Created by erika on 25/02/18.
 *
 */

public class User {

    private String mName;
    private Calendar mDateOfBirth;

    private PersonalIDs mRGandCPF;

    private char mSex;
    private String mNationality;
    private String mMaritalStatus;

    private Address mAddress;
    private CellPhone mCellPhone;

    private String mEmail;
    private PasswordAuthentication mPasswordAuthetication;

    /**
     * Para criar um objeto do tipo usuário, definir e-mail (que serve como userID e senha)
     *
     * @param mEmail
     * @param mPasswordAuthetication
     */
    public User(String mEmail, PasswordAuthentication mPasswordAuthetication) {
        this.mEmail = mEmail;
        this.mPasswordAuthetication = mPasswordAuthetication;
    }


    public String getmName() {
        return mName;
    }

    public void setmName(String name) {
        this.mName = name;
    }

    public Calendar getmDateOfBirth() {
        return mDateOfBirth;
    }

    public void setmDateOfBirth(Calendar dateOfBirth) {
        this.mDateOfBirth = dateOfBirth;
    }

    public PersonalIDs getmRGandCPF() {
        return mRGandCPF;
    }

    public void setmRGandCPF(PersonalIDs rGandCPF) {
        this.mRGandCPF = rGandCPF;
    }

    public char getmSex() {
        return mSex;
    }

    public void setmSex(char sex) {
        this.mSex = sex;
    }

    public String getmNationality() {
        return mNationality;
    }

    public void setmNationality(String nationality) {
        this.mNationality = nationality;
    }

    public String getmMaritalStatus() {
        return mMaritalStatus;
    }

    public void setmMaritalStatus(String maritalStatus) {
        this.mMaritalStatus = maritalStatus;
    }

    public Address getmAddress() {
        return mAddress;
    }

    public void setmAddress(Address address) {
        this.mAddress = address;
    }

    public CellPhone getmCellPhone() {
        return mCellPhone;
    }

    public void setmCellPhone(CellPhone cellPhone) {
        this.mCellPhone = cellPhone;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String email) {
        this.mEmail = email;
    }

    public PasswordAuthentication getmPasswordAuthetication() {
        return mPasswordAuthetication;
    }

    public void setmPasswordAuthetication(PasswordAuthentication passwordAuthetication) {
        this.mPasswordAuthetication = passwordAuthetication;
    }
}
