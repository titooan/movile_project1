package com.titouan.next.movilenext_class1.Seekbar;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class SeekbarViewModel extends ViewModel {

    private MutableLiveData<Integer> value = new MutableLiveData<>();

    public MutableLiveData<Integer> getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value.setValue(value);
    }
}
