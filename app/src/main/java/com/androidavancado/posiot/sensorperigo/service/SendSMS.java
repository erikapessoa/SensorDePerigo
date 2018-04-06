package com.androidavancado.posiot.sensorperigo.service;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidavancado.posiot.sensorperigo.App;
import com.androidavancado.posiot.sensorperigo.model.ButtonData;
import com.androidavancado.posiot.sensorperigo.util.Constants;
import com.androidavancado.posiot.sensorperigo.util.Logger;

import java.util.List;

public class SendSMS  {


    private static final String TAG = "TESTEGPS";
    private static final int LOCATION_INTERVAL = 1000;
    private static final float LOCATION_DISTANCE = 10f;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;


    //Numeros de telefones dos contatos precisam ser recuperados do SharedPreferences
    private static String contact1PhoneNumber = "";
    private static String contact2PhoneNumber = "";
    private static String contact3PhoneNumber = "";

    //Mensagem será montada com mensagem padrão (que está em Constantes.HELP_ME) + localização do GPS.
    private static String sMSMessage = Constants.HELP_ME;


    private LocationManager mLocationManager = null;

    Location mLastLocation;


    LocationListener[] mLocationListeners = new LocationListener[] {
            new LocationListener(LocationManager.GPS_PROVIDER),
            new LocationListener(LocationManager.NETWORK_PROVIDER)
    };


    /**
     * Precisa ver como fazer modificações nesse método e no debaixo para que eles não precisem de uma Activity
     *
     */
    public static void sendSMS() {
        /*
        if (ContextCompat.checkSelfPermission(App.getContext(), Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(App.getContext(), Manifest.permission.SEND_SMS)) {
                //Esse if não faz nada???
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
        */
    }

    /**
     * Esse método precisa pegar as informações dos telefones de contato (do SharedPreferences e
     * montar URL de localização para enviar na mensagem SMS
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */

    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {

               /*
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(phoneNumber, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
                */
            }
        }


    }


    //##################################################
    // UTILIZADO PARA PEGAR A LOCALIZAÇÃO DO USUÁRIO
    private class LocationListener implements android.location.LocationListener
    {


        public LocationListener(String provider)
        {
            Logger.d(TAG + "LocationListener " + provider);
            mLastLocation = new Location(provider);
        }

        @Override
        public void onLocationChanged(Location location)
        {
            Logger.d(TAG +  "onLocationChanged: " + location);
            mLastLocation.set(location);
        }

        @Override
        public void onProviderDisabled(String provider)
        {
            Logger.d(TAG + "onProviderDisabled: " + provider);
        }

        @Override
        public void onProviderEnabled(String provider)
        {
            Logger.d(TAG + "onProviderEnabled: " + provider);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras)
        {
            Logger.d(TAG + "onStatusChanged: " + provider);
        }
    }

    private void initializeLocationManager() {
        Logger.d(TAG +  "initializeLocationManager");
        if (mLocationManager == null) {
            mLocationManager = (LocationManager) App.getContext().getSystemService(Context.LOCATION_SERVICE);
        }
    }

    public void requestUpdate()
    {
        try {
            mLocationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER, LOCATION_INTERVAL, LOCATION_DISTANCE,
                    mLocationListeners[1]);
        } catch (java.lang.SecurityException ex) {
            Logger.e(TAG +  "fail to request location update, ignore", ex);
        } catch (IllegalArgumentException ex) {
            Logger.d(TAG +  "network provider does not exist, " + ex.getMessage());
        }

        try {
            mLocationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, LOCATION_INTERVAL, LOCATION_DISTANCE,
                    mLocationListeners[0]);
        } catch (java.lang.SecurityException ex) {
            Logger.e(TAG +  "fail to request location update, ignore", ex);
        } catch (IllegalArgumentException ex) {
            Logger.d(TAG +  "gps provider does not exist " + ex.getMessage());
        }
    }

    //##################################################
}
