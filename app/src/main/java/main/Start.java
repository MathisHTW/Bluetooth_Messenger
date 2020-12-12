package main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        final Intent channel = new Intent(this, Channel.class);
        final Intent create = new Intent(this, CreateChannel.class);
        Button buttonChannel = findViewById(R.id.btnJoin);
        Button buttonCreate = findViewById(R.id.btnCreateChannel);

        buttonChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(channel);
            }
        });

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(create);
            }
        });

        new ASAPInit();
    }
}