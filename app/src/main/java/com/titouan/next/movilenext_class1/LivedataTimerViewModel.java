package com.titouan.next.movilenext_class1;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.SystemClock;

import java.util.Timer;
import java.util.TimerTask;

public class LivedataTimerViewModel extends ViewModel {

    private MutableLiveData<Long> elapsedTime = new MutableLiveData<>();

    private static final int ONE_SECOND = 1000;
    private long initialTime;

    public LivedataTimerViewModel() {
        initialTime = SystemClock.elapsedRealtime();

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long newValue = (SystemClock.elapsedRealtime() - initialTime) / 1000;

                elapsedTime.postValue(newValue);
            }
        }, ONE_SECOND, ONE_SECOND);

    }

    public MutableLiveData<Long> getElapsedTime() {
        return elapsedTime;
    }
}
