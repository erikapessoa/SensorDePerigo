package com.androidavancado.posiot.sensorperigo.util;

import java.util.Calendar;

/**
 * Created by erika on 25/02/18.
 */

public class Util {

    /**
     *
     * @param nome
     * @param latitude
     * @param longitude
     * @return
     */
    public static String mensagem(String nome, double latitude, double longitude)
    {

        return nome + Constants.HELP_ME + Constants.MAP_URL_LOCALIZATION + longitude + "," + latitude;

    }

    /**
     *
     * @param day
     * @param month
     * @param year
     * @return
     */
    public static Calendar mountDate(int day, int month, int year) {

        Calendar date = null;

        return date;
    }

    /**
     *
     * @param cpf
     * @return
     */
    public static boolean validateCPF (String cpf) {

        boolean isCPF = false;

        return isCPF;
    }

    /**
     * Considera um número de celular brasileiro contendo 9 números
     * e começando com 9.
     *
     * @param number
     * @return
     */
    public static boolean validateCellPhoneNumber (String number) {

        boolean isCellPhoneNumber = false;

        return isCellPhoneNumber;
    }


}
