package com.androidavancado.posiot.sensorperigo.util;

/**
 * Created by erika on 25/02/18.
 */

public class Constants {

    /*
    User credentials
    UUID 14966c4d-c321-4886-bfbd-780424660000
    Token c7ef482fdbce034f5c44c7df3c7624c59e5ab9c5

    Gateway credentials
    UUID 5ae20ba3-3ff0-444c-bfca-447083cb0000
    Token d4c2f316b2b1e8baf7d2b573a21700cdf53daaaa
    */


    public static final String APP_NAME = "Sensor de Perigo";

    public static final String KNOT_URL = "http://knot-test.cesar.org.br:3000";
    public static final String DEFAULT_UUID = "14966c4d-c321-4886-bfbd-780424660000";
    public static final String DEFAULT_TOKEN = "c7ef482fdbce034f5c44c7df3c7624c59e5ab9c5";

    /*
    public static final String KEY_END_POINT = "http://knot-test.cesar.org.br:3000";
    public static final String KEY_UUID = "14966c4d-c321-4886-bfbd-780424660000";
    public static final String KEY_TOKEN = "c7ef482fdbce034f5c44c7df3c7624c59e5ab9c5";
    */


    public static final char FEMININ_SEX = 'F';
    public static final char MASCULIN_SEX = 'M';
    public static final char OTHER_SEX = 'O';

    public static final String SINGLE_MARITAL_STATUS  = "SINGLE";
    public static final String WIDOW_MARITAL_STATUS  = "WIDOW";
    public static final String MARRIED_MARITAL_STATUS  = "MARRIED";
    public static final String DIVORCED_MARITAL_STATUS  = "DIVORCED";

    public static final String HELP_ME = "Estou precisando de ajuda urgente! Me encontro no seguinte local: ";
    public static final String MAP_URL_LOCALIZATION = "https://www.google.com/maps/?q= ";

    /* Contantes usadas no Shared Preferences */
    public static final String SENSOR_PERIGO_PREF = "SensorPerigoPreferences";
    public static final String SP_CONTACT_NAME = "CONTACT_NAME_";
    public static final String SP_CONTACT_CELLPHONE = "CONTACT_CELLPHONE_";
    public static final String SP_CONTACT_EMAIL = "CONTACT_EMAIL_";


}
