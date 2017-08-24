package com.acme.randomnumberstreamer;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class RandomNumberStreamer {

    private BindableLiveData<String> liveData;

    private Random random;
    private Timer timer;

    public RandomNumberStreamer() {
        random = new Random(System.currentTimeMillis());
        liveData = new BindableLiveData<>("0");
    }

    public BindableLiveData<String> openLiveNumberStream(int emitEveryNumSeconds) {
        startTimer(emitEveryNumSeconds);
        return liveData;
    }

    public void cancelTimer() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
            timer = null;
        }
    }

    private void startTimer(int emitEveryNumSeconds) {

        cancelTimer();

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                liveData.postValue(String.valueOf(random.nextInt(100)));
            }
        }, 500, emitEveryNumSeconds * 1000);
    }

}
