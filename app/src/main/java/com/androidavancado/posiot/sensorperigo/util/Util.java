package com.androidavancado.posiot.sensorperigo.util;

import java.util.Calendar;

/**
 * Created by erika on 25/02/18.
 */

public class Util {

    static String cpf;

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

        if ( cpf == null ){
            return false;
        }
        else{
            String cpfGerado = "";
            Util.cpf = cpf;
            removerCaracteres();
            if ( verificarSeTamanhoInvalido(Util.cpf) )
                return false;
            if ( verificarSeDigIguais(Util.cpf) )
                return false;
            cpfGerado = Util.cpf.substring(0, 9);
            cpfGerado = cpfGerado.concat(calculoComCpf(cpfGerado));
            cpfGerado = cpfGerado.concat(calculoComCpf(cpfGerado));

            if ( !cpfGerado.equals(Util.cpf))
                return false;
        }
        return true;

    }

    private static void removerCaracteres(){
        Util.cpf = Util.cpf.replace("-","");
        Util.cpf = Util.cpf.replace(".","");
    }
    private static boolean verificarSeTamanhoInvalido(String cpf){
        if ( cpf.length() != 11 )
            return true;
        return false;
    }
    private static boolean verificarSeDigIguais(String cpf){
        //char primDig = cpf.charAt(0);
        char primDig = '0';
        char [] charCpf = cpf.toCharArray();
        for( char c: charCpf  )
            if ( c != primDig )
                return false;
        return true;
    }
    private static String calculoComCpf(String cpf){
        int digGerado = 0;
        int mult = cpf.length()+1;
        char [] charCpf = cpf.toCharArray();
        for ( int i = 0; i < cpf.length(); i++ )
            digGerado += (charCpf[i]-48)* mult--;
        if ( digGerado % 11 < 2)
            digGerado = 0;
        else
            digGerado = 11 - digGerado % 11;
        return  String.valueOf(digGerado);
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
