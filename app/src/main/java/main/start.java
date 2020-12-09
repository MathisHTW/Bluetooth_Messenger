package main;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluetoothmessenger.R;

import main.controller.asap.ASAPInit;

public class start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ASAPInit init = new ASAPInit();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}