package com.titouan.next.movilenext_class1.ViewModel;

import android.arch.lifecycle.ViewModelProviders;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.titouan.next.movilenext_class1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.chronometer)
    protected Chronometer chronometer;

    @BindView(R.id.start)
    protected Button startButton;

    private ChronometerViewModel chronometerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        chronometerViewModel = ViewModelProviders.of(this)
                                                 .get(ChronometerViewModel.class);

        if (chronometerViewModel.getStartTime() != null) {
            chronometer.setBase(chronometerViewModel.getStartTime());
            chronometer.start();
            startButton.setEnabled(false);
        }
    }

    @OnClick(R.id.start)
    protected void start(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
        chronometerViewModel.setStartTime(chronometer.getBase());
        view.setEnabled(false);
    }
}
