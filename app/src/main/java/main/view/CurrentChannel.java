package main.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.sharksystem.asap.ASAPException;
import net.sharksystem.asap.ASAPMessages;
import net.sharksystem.asap.android.apps.ASAPMessageReceivedListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.R;
import main.controller.asap.BTApplication;
import main.controller.asap.BTRootActivity;
import main.controller.AppController;
import main.controller.logic.CRUD.Create;

public class CurrentChannel extends BTRootActivity {

    private AppController appController = AppController.instance;

    private static final CharSequence URI = "asap://exampleURI";
    private static final CharSequence EXAMPLE_MESSAGE = "Send a Msg";
    private ASAPMessageReceivedListener receivedListener;
    private List<String> sentMessages = new ArrayList<>();
    private List<String> receivedMessages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_s_a_p);

        appController.onActivityCreated(this, savedInstanceState);

        TextView textView = findViewById(R.id.textViewChannelName);
        textView.setText("ASPA has been started");

        if (!this.isBluetoothEnvironmentOn()) {
            Log.d(this.getLogStart(), "start bt button pressed - ask service to start bt");
            super.startBluetooth();
        }

        EditText messageEditView = findViewById(R.id.editTextNewMessage);
        messageEditView.setText(EXAMPLE_MESSAGE);

        this.receivedListener = new ASAPMessageReceivedListener() {
            @Override
            public void asapMessagesReceived(ASAPMessages asapMessages) {
                Log.d("receivedListener", "asapMessageReceived");
                CurrentChannel.this.doHandleReceivedMessages(asapMessages);
                Log.e("receivedListener", asapMessages.toString());
            }
        };

        // set listener to get informed about newly arrived messages
        this.getASAPApplication().addASAPMessageReceivedListener(
                BTApplication.ASAP_Messenger, // listen to this app
                this.receivedListener
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
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

    private void doHandleReceivedMessages(ASAPMessages asapMessages) {
        Log.d(this.getLogStart(), "going to handle received messages with uri: "
                + asapMessages.getURI());

        // set up output
        StringBuilder sb = new StringBuilder();
        Create create = new Create();

        try {
            Iterator<CharSequence> messagesAsCharSequence = asapMessages.getMessagesAsCharSequence();
            while (messagesAsCharSequence.hasNext()) {
                String receivedMessage = messagesAsCharSequence.next().toString();
                this.receivedMessages.add(receivedMessage);
                sb.append(receivedMessage);
            }

            for (String msg : this.sentMessages) {
                //create.createMessage(String.valueOf(asapMessages.getURI()), msg);
                sb.append(msg);
                sb.append("\n");
            }

            for (String msg : this.receivedMessages) {
                //create.createMessage(String.valueOf(asapMessages.getURI()), msg);
                sb.append(msg);
            }
        } catch (IOException e) {
            Log.e("Error", "problems when handling received messages: "
                    + e.getLocalizedMessage());
            sb.append(e.getLocalizedMessage());
        }

        TextView receivedMessagesTV = findViewById(R.id.textViewForASAPMessenges);
        receivedMessagesTV.setMovementMethod(new ScrollingMovementMethod());
        Log.e("Debug", sb.toString());
        receivedMessagesTV.setText(sb.toString());
    }

    public void onClick(View view) {
        Log.e("Debug", "Press Send Btn");

        EditText messageEditView = findViewById(R.id.editTextNewMessage);
        Editable messageText = messageEditView.getText();

        Log.d(this.getLogStart(), "going to send message: " + messageText);

        // asap messages are bytes
        byte[] byteContent = messageText.toString().getBytes();

        Log.d(this.getLogStart(), "going to send messageBytes: " + byteContent);

        this.sendMessage(byteContent);

        // success - remember sent message
        this.sentMessages.add(messageText.toString());
    }

    private void sendMessage(byte[] byteContent) {
        try {
            this.sendASAPMessage(
                    BTApplication.ASAP_Messenger,
                    URI,
                    byteContent,
                    true);
        } catch (ASAPException e) {
            Log.e(this.getLogStart(), "when sending asap message: " + e.getLocalizedMessage());
        }
    }

    public void onClickBluetooth(View view) {
        super.startBluetoothDiscovery();
        super.startBluetoothDiscoverable();
    }
}