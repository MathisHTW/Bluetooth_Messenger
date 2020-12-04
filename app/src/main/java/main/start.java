package main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bluetoothmessenger.R;

import main.controller.asap.ASAPInit;

public class start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ASAPInit init = new ASAPInit();
        init.onCreate(savedInstanceState);
    }
}