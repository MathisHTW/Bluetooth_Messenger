package main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import java.util.Objects;

import main.controller.asap.BTRootActivity;
import main.controller.AppController;
import main.controller.logic.stream.localStorage.LocalStorage;
import main.modell.storage.Storage;
import main.modell.storage.StorageAsSingelton;
import main.view.Channel;
import main.view.CreateChannel;
import main.view.Settings;

public class Start extends BTRootActivity {

    private AppController appController = AppController.instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final LocalStorage localStorage = new LocalStorage();
        try {
            Storage storage = StorageAsSingelton.getIntance();
            Storage save = localStorage.read(getApplication());

            if (!save.getChannelList().isEmpty()) {
                storage.addAllChannelList(save.getChannelList());
            }

            if (!save.getNotificationList().isEmpty()) {
                storage.addAllNotification(save.getNotificationList());
            }

            if (!save.getUserList().isEmpty()) {
                storage.addAllUser(save.getUserList());
            }

        } catch (NullPointerException e) {
            Log.i("Save", Objects.requireNonNull(e.getMessage()));
        }

        appController.onActivityCreated(this, savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.loadChannelActivity();
        this.loadCreateChannelActivity();
        this.loadCreateSettingActivity();
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

    private void loadCreateSettingActivity(){
        final Intent intent = new Intent(this, Settings.class);
        Button buttonSetting = findViewById(R.id.btnChangeName);
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

}