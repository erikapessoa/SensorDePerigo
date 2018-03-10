package com.androidavancado.posiot.sensorperigo.util;

import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

import com.androidavancado.posiot.sensorperigo.App;
import com.androidavancado.posiot.sensorperigo.R;
import com.androidavancado.posiot.sensorperigo.model.User;
import com.androidavancado.posiot.sensorperigo.ui.LoginActivity;

import java.util.Calendar;
import java.util.regex.Pattern;


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


    // ****** Validando Email *********** //
    public static boolean validateEmail(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
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

    private static EditText mUsuario;
    private static EditText mSenha;


  //  mUsuario = (EditText) findViewById(R.id.usuarioText);
  //  mSenha = (EditText) findViewById(R.id.password);

    // ******** Cadastrar os dados do usuário no SheredPrefer *******
    public static void registerUser (User user) {

        SharedPreferences settings = App.getContext().getSharedPreferences(Constants.ARCHIVE_PREF, 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("login", mUsuario.getText().toString());
        editor.putString("senha", mSenha.getText().toString());
        editor.commit();
    }


    // Verificar login do usuário no SheredPreferences
    public static boolean verifyUser (String email, String password) {

        boolean isOk = false;

        return isOk;
        // Recuperar os dados salvos

        /*
        SharedPreferences settings = getSharedPreferences(Constants.ARCHIVE_PREF, 0);
        if(settings.contains("login") && settings.contains("senha") ){
            //abrir main_menu
        } else{
            Toast.makeText(getApplicationContext(), "Esse usuário não foi cadastrado", Toast.LENGTH_SHORT);

        }
        */

    }


}
