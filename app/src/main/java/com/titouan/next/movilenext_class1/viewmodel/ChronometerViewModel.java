package com.titouan.next.movilenext_class1.viewmodel;

import android.arch.lifecycle.ViewModel;

public class ChronometerViewModel extends ViewModel {

    private Long startTime;
    private boolean isRunning = false;

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
