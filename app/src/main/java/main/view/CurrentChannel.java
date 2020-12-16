package main.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import main.R;
import main.controller.asap.ASAPActivity;
import main.controller.asap.ASAPApplication;

public class CurrentChannel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ASAPApplication.applicationInstance(this);
        this.finish();
        Intent intent = new Intent(this, ASAPActivity.class);
        this.startActivity(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();

        final TextView channelName = findViewById(R.id.textViewChannelName);
        final EditText editText = (EditText) findViewById(R.id.editTextNewMessage);
        final Button sendButton = findViewById(R.id.buttonSendMessage);

        //final Intent intent = new Intent(this, ASAPMessagingActivity.class);??

        //Send message and refresh view
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                //Nachricht mit ASAP verschicken:

                //View refreshen mit Nachrichten aus diesem Channel
            }
        });

        //bentötigt noch listener für empfangenen messages:

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}