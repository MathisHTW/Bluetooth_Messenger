package main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import main.view.Channel;
import main.view.CreateChannel;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

    }

    @Override
    protected void onStart() {
        super.onStart();
        this.loadChannelActivity();
        this.loadCreateChannelActivity();
    }

    private void changeName(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Start.this);
        builder.setMessage("Change your Name: ");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
    }

    private void loadChannelActivity() {
        final Intent channel = new Intent(this, Channel.class);
        Button buttonChannel = findViewById(R.id.btnJoin);

        buttonChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(channel);
            }
        });
    }

    private void loadCreateChannelActivity() {
        final Intent create = new Intent(this, CreateChannel.class);
        Button buttonCreate = findViewById(R.id.btnCreateChannel);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(create);
            }
        });
    }

}