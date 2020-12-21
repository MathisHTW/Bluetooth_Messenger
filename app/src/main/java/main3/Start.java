package main3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import main3.controller.asap.BTRootActivity;
import main3.controller.logic.AppController;
import main3.modell.storage.Storage;
import main3.modell.storage.StorageAsSingelton;
import main3.view.Channel;
import main3.view.CreateChannel;

public class Start extends BTRootActivity {

    private AppController appController = AppController.instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        appController.onActivityCreated(this, savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.loadChannelActivity();
        this.loadCreateChannelActivity();
        Storage storage = StorageAsSingelton.getIntance();

        if (!storage.hasName()) {
            changeName();
        }
        appController.onActivityStarted(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        appController.onActivityResumed(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        appController.onActivityPaused(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        appController.onActivityStopped(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appController.onActivityDestroyed(this);
    }

    private void changeName() {
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