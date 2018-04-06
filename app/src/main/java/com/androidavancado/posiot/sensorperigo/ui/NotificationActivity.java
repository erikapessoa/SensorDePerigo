package com.androidavancado.posiot.sensorperigo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androidavancado.posiot.sensorperigo.R;
import com.androidavancado.posiot.sensorperigo.model.CellPhone;
import com.androidavancado.posiot.sensorperigo.model.Contact;
import com.androidavancado.posiot.sensorperigo.service.SendSMS;
import com.androidavancado.posiot.sensorperigo.util.Logger;
import com.androidavancado.posiot.sensorperigo.util.Util;

import java.util.ArrayList;
import java.util.List;

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
    public void saveContacts (View v) {

        //Pega os dado do layout para validar, se tiver ok, tenta salvar, se tiver errado, volta pra mesma tela

        String nameContact1 = ((EditText) findViewById(R.id.editTextContactName1)).getText().toString();
        String cellPhoneDDDContact1 = ((EditText) findViewById(R.id.editTextContactCellPhoneDDD1)).getText().toString();
        String cellPhoneNumberContact1 = ((EditText) findViewById(R.id.editTextContactCellPhoneNumber1)).getText().toString();
        String emailContact1 = ((EditText) findViewById(R.id.editTextContactEmail1)).getText().toString();

        String nameContact2 = ((EditText) findViewById(R.id.editTextContactName2)).getText().toString();
        String cellPhoneDDDContact2 = ((EditText) findViewById(R.id.editTextContactCellPhoneDDD2)).getText().toString();
        String cellPhoneNumberContact2 = ((EditText) findViewById(R.id.editTextContactCellPhoneNumber2)).getText().toString();
        String emailContact2 = ((EditText) findViewById(R.id.editTextContactEmail2)).getText().toString();

        String nameContact3 = ((EditText) findViewById(R.id.editTextContactName3)).getText().toString();
        String cellPhoneDDDContact3 = ((EditText) findViewById(R.id.editTextContactCellPhoneDDD3)).getText().toString();
        String cellPhoneNumberContact3 = ((EditText) findViewById(R.id.editTextContactCellPhoneNumber3)).getText().toString();
        String emailContact3 = ((EditText) findViewById(R.id.editTextContactEmail3)).getText().toString();


        if (nameContact1.equals("") || cellPhoneDDDContact1.equals("") || cellPhoneNumberContact1.equals("") ||
                emailContact1.equals("") || nameContact2.equals("") || cellPhoneDDDContact2.equals("") || cellPhoneNumberContact2.equals("") ||
                emailContact2.equals("") || nameContact3.equals("") || cellPhoneDDDContact3.equals("") || cellPhoneNumberContact3.equals("") ||
                emailContact3.equals("")  ) {

            Toast.makeText(getApplicationContext(), "Nenhum campo pode estar em branco. Preencha todos os campos " +
                            "e tente salvar novamente!",
                    Toast.LENGTH_LONG).show();


        } /* else if (!Util.validateCellPhoneNumber(cellPhoneNumberContact1) || !Util.validateEmail(emailContact1) ||
                !Util.validateCellPhoneNumber(cellPhoneNumberContact2) || !Util.validateEmail(emailContact2) ||
                !Util.validateCellPhoneNumber(cellPhoneNumberContact3) || !Util.validateEmail(emailContact3)) {

            Toast.makeText(getApplicationContext(), "Verifique os números de celular e e-mail de cada contato " +
                            "e tente salvar novamente!",
                    Toast.LENGTH_LONG).show();

        } */ else {

            int dDD = 0;
            CellPhone cellphone = new CellPhone();
            char[] cellphoneNumber;

            dDD = Integer.parseInt(cellPhoneDDDContact1);
            cellphoneNumber = cellPhoneNumberContact1.toCharArray();
            cellphone.setmDDD(dDD);
            cellphone.setmNumber(cellphoneNumber);

            Logger.d("cellPhone 1 : " + cellphone.toString());

            Contact contact1 = new Contact(nameContact1, emailContact1, cellphone);

            cellphone = new CellPhone();
            dDD = Integer.parseInt(cellPhoneDDDContact2);
            cellphoneNumber = cellPhoneNumberContact2.toCharArray();
            cellphone.setmDDD(dDD);
            cellphone.setmNumber(cellphoneNumber);

            Logger.d("cellPhone 2 : " + cellphone.toString());

            Contact contact2 = new Contact(nameContact2, emailContact2, cellphone);

            cellphone = new CellPhone();
            dDD = Integer.parseInt(cellPhoneDDDContact3);
            cellphoneNumber = cellPhoneNumberContact3.toCharArray();
            cellphone.setmDDD(dDD);
            cellphone.setmNumber(cellphoneNumber);

            Logger.d("cellPhone 3 : " + cellphone.toString());

            Contact contact3 = new Contact(nameContact3, emailContact3, cellphone);


            List<Contact> contacts = new ArrayList<Contact>();
            contacts.add(contact1);
            contacts.add(contact2);
            contacts.add(contact3);

            Util.saveUserContacts(contacts);

            Toast.makeText(getApplicationContext(), "Contatos SALVOS com sucesso!",
                    Toast.LENGTH_LONG).show();

        }
    }

}
