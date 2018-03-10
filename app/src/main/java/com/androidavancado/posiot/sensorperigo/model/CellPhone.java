package com.androidavancado.posiot.sensorperigo.model;

import java.util.Arrays;

/**
 * Created by erika on 06/03/18.
 */

public class CellPhone {

    private int mDDI; //por eqt, apenas Brasil
    private int mDDD;
    private char[] mNumber; //considerar, por eqt que precisa ter 9 números (padrão celular brasil)

    /**
     *
     */
    public CellPhone() {

        this.mDDI = 55;
        this.mDDD = 81;
        this.mNumber = new char[9];
    }

    public int getmDDI() {
        return mDDI;
    }

    public void setmDDI(int dDI) {
        this.mDDI = dDI;
    }

    public int getmDDD() {
        return mDDD;
    }

    public void setmDDD(int dDD) {
        this.mDDD = dDD;
    }

    public char[] getmNumber() {
        return mNumber;
    }

    public void setmNumber(char[] number) {
        this.mNumber = number;
    }

    /**
     * Retorna o número do celular em formato de String
     * @return
     */
    public String charToStringNumber() {
        return mNumber.toString();
    }



    /**
     * Retorna o número completo com DDI, DDD e número.
     *
     * @return String contendo o número de celular
     */
    @Override
    public String toString() {
        return mDDI + mDDD + charToStringNumber();
    }
}
