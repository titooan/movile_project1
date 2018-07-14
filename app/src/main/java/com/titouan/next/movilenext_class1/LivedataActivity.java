package com.titouan.next.movilenext_class1;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LivedataActivity extends AppCompatActivity {

    @BindView(R.id.timer)
    protected TextView timer;

    private LivedataTimerViewModel livedataTimerViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livedata);
        ButterKnife.bind(this);

        livedataTimerViewModel = ViewModelProviders
                .of(this)
                .get(LivedataTimerViewModel.class);

        subscribe();
    }

    private void subscribe() {
        final Observer<Long> elapsedTimeObserver = aLong ->
                timer.setText(getString(R.string.seconds, aLong));

        livedataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver);
    }
}
