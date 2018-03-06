package com.androidavancado.posiot.sensorperigo.util;

/**
 * Created by erika on 25/02/18.
 */

public class Util {

    public static String mensagem(String nome, double latitude, double longitude)
    {

        return nome + Constants.HELP_ME + Constants.MAP_URL_LOCALIZATION + longitude + "," + latitude;

    }

}
