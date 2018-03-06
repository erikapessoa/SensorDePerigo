package com.androidavancado.posiot.sensorperigo.util;

/**
 * Created by erika on 25/02/18.
 */

public class Util {

    public static String mensagem(String nome, double latitude, double longitude)
    {

        return nome + "Estou precisando de ajuda urgente! Me encontro no seguinte local: " +
                "https://www.google.com/maps/?q= " + longitude + "," + latitude;

    }

}
