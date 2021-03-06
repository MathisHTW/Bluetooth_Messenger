package main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import main.controller.AppController;
import main.controller.asap.BTRootActivity;
import main.controller.logic.CRUD.Create;
import main.controller.logic.CRUD.Read;
import main.modell.storage.Storage;
import main.view.Channel;
import main.view.CreateChannel;
import main.view.Settings;

public class Start extends BTRootActivity {

    private AppController appController = AppController.instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        final Read read = new Read();
        read.localStorage(getApplication());

        if (Storage.getInstance().getChannelList().size() == 0) {
            final Create create = new Create();
            create.createChannel("Public");
        }

        appController.onActivityCreated(this, savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.initOnClickEvents();
        this.appController.onActivityStarted(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.appController.onActivityResumed(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.appController.onActivityPaused(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.appController.onActivityStopped(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.appController.onActivityDestroyed(this);
    }

    private void changeName() {
        final Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    private void initOnClickEvents() {
        this.loadCreateSettingActivity();
        this.loadCreateChannelActivity();
        this.loadChannelActivity();
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

    private void loadCreateSettingActivity() {
        final Intent intent = new Intent(this, Settings.class);
        Button buttonSetting = findViewById(R.id.btnCreateAppOwner);
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}