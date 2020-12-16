package main.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import main.R;
import main.controller.logic.CRUD.Create;
import main.modell.storage.Storage;
import main.modell.storage.StorageAsSingelton;

public class CreateChannel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_channel);
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
                boolean check = new Create().createChannel(textView.getText().toString());
                if (check) {
                    startActivity(intent);
                }
            }
        });
    }
}