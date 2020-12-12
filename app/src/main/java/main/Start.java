package main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import main.controller.asap.ASAPInit;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

    }

    @Override
    protected void onStart() {
        super.onStart();
        new ASAPInit();
    }
}