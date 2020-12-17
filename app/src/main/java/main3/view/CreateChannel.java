package main3.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import main3.R;
import main3.controller.asap.BTRootActivity;
import main3.controller.logic.CRUD.Create;

public class CreateChannel extends BTRootActivity {

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