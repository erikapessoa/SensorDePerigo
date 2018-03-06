
package com.androidavancado.posiot.sensorperigo.util;

import android.support.annotation.NonNull;
import android.util.Log;

import br.org.cesar.knot.lib.BuildConfig;

/**
 * The type Log lib.
 */
public class Logger {

    private static final String TAG = "Diego";

    /**
     * Log print the given message
     *
     * @param message the message
     */
    public static void d(@NonNull String message) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, message);
        }
    }

    /**
     * Log print error with message.
     *
     * @param message the message
     * @param error   the error
     */
    public static void e(@NonNull String message, Throwable error) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, message, error);
        }
    }

    /**
     * Log print error with message.
     *
     * @param error   the error
     */
    public static void e(Throwable error) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, TAG, error);
        }
    }

}
