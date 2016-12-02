package com.flyingtophat.daggermockexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.flyingtophat.daggermockexample.domain.ButtonTextService;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    protected ButtonTextService buttonTextService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getAppComponent().inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        Button button = (Button)findViewById(R.id.button);
        button.setText(buttonTextService.getText());
    }
}
