package com.androidavancado.posiot.sensorperigo;

import android.app.Application;
import android.content.Context;

/**
 * Created by erika on 25/02/18.
 */

public class App extends Application {

    private static Context mContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    /**
     * Gets context.
     *
     * @return the context
     */
    public static Context getContext() {
        return mContext;
    }
}
