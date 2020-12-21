package main.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import main.R;
import main.controller.asap.BTRootActivity;
import main.controller.logic.AppController;
import main.controller.logic.CRUD.Create;

public class CreateChannel extends BTRootActivity {

    private AppController appController = AppController.instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_channel);
        AppController.instance.onActivityCreated(this, savedInstanceState);
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
                boolean check = create.createChannel(textView.getText().toString());
                if (check) {
                    startActivity(intent);
                }
            }
        });
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
}