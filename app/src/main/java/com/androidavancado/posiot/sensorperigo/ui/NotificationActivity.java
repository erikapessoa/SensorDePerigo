package com.androidavancado.posiot.sensorperigo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.androidavancado.posiot.sensorperigo.R;

public class NotificationActivity extends AppCompatActivity {

    private boolean updateContacts = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        /**
         * Precisa verificar se já existem contatos salvos. Se existirem, precisa preencher os campos, se
         * não existir, abre a tela vazia
         */

    }

    /**
     *
     * @param v
     */
    public void cancel (View v) {
        //aqui volta para a tela anterior
    }

    /**
     *
     * @param v
     */
    public void saveContacts (View v) {

        //Pega os dado do layout para validar, se tiver ok, tenta salvar, se tiver errado, volta pra mesma tela

        String nameContact1 = ((EditText) findViewById(R.id.editTextContactName1)).getText().toString();
        String cellPhoneDDDContact1 = ((EditText) findViewById(R.id.editTextContactCellPhoneDDD1)).getText().toString();
        String cellPhoneNumberContact1 = ((EditText) findViewById(R.id.editTextContactCellPhoneNumber1)).getText().toString();

        String nameContact2 = ((EditText) findViewById(R.id.editTextContactName2)).getText().toString();
        String cellPhoneDDDContact2 = ((EditText) findViewById(R.id.editTextContactCellPhoneDDD2)).getText().toString();
        String cellPhoneNumberContact2 = ((EditText) findViewById(R.id.editTextContactCellPhoneNumber2)).getText().toString();

        String nameContact3 = ((EditText) findViewById(R.id.editTextContactName3)).getText().toString();
        String cellPhoneDDDContact3 = ((EditText) findViewById(R.id.editTextContactCellPhoneDDD3)).getText().toString();
        String cellPhoneNumberContact3 = ((EditText) findViewById(R.id.editTextContactCellPhoneNumber3)).getText().toString();

        //if()
    }

}
