package com.androidavancado.posiot.sensorperigo.util;

import android.os.CountDownTimer;

/**
 * Created by erika on 25/02/18.
 */

public class PoolingTimer {
    private PoolingListener listener;

    private static final long TWO_SECONDS = 1000 * 1;

    private CountDownTimer countDownTimer;

    private long periodPooling;

    public PoolingTimer(long intervalTick, PoolingListener listener) {
        this.listener = listener;
        this.periodPooling = intervalTick;
        countDownTimer = new Task(TWO_SECONDS, intervalTick);
    }

    public PoolingTimer(PoolingListener listener) {
        this(TWO_SECONDS, listener);
    }

    /**
     * Init the pooling
     */
    public void startPooling() {
        if (countDownTimer != null) {
            countDownTimer.cancel();

            // create a new CounterDown and start it
            countDownTimer = getTime();
            countDownTimer.start();
            Logger.d("Pooling started");
        }
    }

    /**
     * Stop the pooling
     */
    public void stopPooling() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private Task getTime() {
        return new Task(TWO_SECONDS, periodPooling);
    }


    private class Task extends CountDownTimer {

        public Task(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            if (listener != null) {
                Logger.d("Pooling Ticked");
                listener.onPoolingFinished();
            }
        }

        @Override
        public void onFinish() {
            // infinite loop
            Logger.d("Pooling Restarted");
            start();
        }
    }

    /**
     * Listener used to retrieve the result of pooling
     */
    public interface PoolingListener {
        public void onPoolingFinished();
    }
}

