package main.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import main.R;
import main.controller.asap.BTRootActivity;
import main.controller.AppController;
import main.controller.logic.CRUD.Create;

public class CreateChannel extends BTRootActivity {

    private TextView view;
    private AppController appController = AppController.instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_channel);
        AppController.instance.onActivityCreated(this, savedInstanceState);
        this.view = findViewById(R.id.CreateChannelError);
        this.view.setText(null);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final Button button = findViewById(R.id.btnCreate);
        final TextView textView = findViewById(R.id.textViewName);
        final Intent intent = new Intent(this, Channel.class);

        /**
         * Open a Channel View
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Create create = new Create();
                boolean check = false;

                try {
                    check = create.createChannel(textView.getText().toString());
                } catch (IllegalArgumentException | IllegalStateException e) {
                    Log.e("CreateChannel", e.getMessage());
                    view.setText(e.getMessage());
                    view.setTextSize(20);
                    view.setBackgroundColor(Color.RED);
                }

                if (check) {
                    startActivity(intent);
                }
            }
        });
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
}