package com.androidavancado.posiot.sensorperigo.model;

/**
 * Created by erika on 06/03/18.
 */

public class Address {

    // Logradouro: N°: Bairro: Cidade: Estado: País: CEP:

    private String mPublicPlace;
    private int mNumber;
    private String mNeighborhood;
    private String mCity;
    private  String mState;
    private String mCountry;
    private char[] mZipCode;

    /**
     * Inicializa o endereço com valores default de cada membro
     *
     */
    public Address() {
        //inicializar com valores padrão
        mPublicPlace = "";
        mNumber = 0;
        mNeighborhood = "";
        mCity = "";
        mState = "";
        mCountry = "";
        mZipCode = new char[8];
    }

    public String getmPublicPlace() {
        return mPublicPlace;
    }

    public void setmPublicPlace(String publicPlace) {
        this.mPublicPlace = publicPlace;
    }

    public int getmNumber() {
        return mNumber;
    }

    public void setmNumber(int number) {
        this.mNumber = number;
    }

    public String getmNeighborhood() {
        return mNeighborhood;
    }

    public void setmNeighborhood(String neighborhood) {
        this.mNeighborhood = neighborhood;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String city) {
        this.mCity = city;
    }

    public String getmState() {
        return mState;
    }

    public void setmState(String state) {
        this.mState = state;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String country) {
        this.mCountry = country;
    }

    public char[] getmZipCode() {
        return mZipCode;
    }

    public void setmZipCode(char[] zipCode) {
        this.mZipCode = zipCode;
    }
}
