package main.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.sharksystem.asap.ASAPException;
import net.sharksystem.asap.ASAPMessages;
import net.sharksystem.asap.android.apps.ASAPMessageReceivedListener;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.R;
import main.controller.asap.BTApplication;
import main.controller.asap.BTRootActivity;
import main.controller.AppController;
import main.controller.logic.stream.SerializableMessages;
import main.controller.logic.stream.SerializeMessages;
import main.modell.storage.Storage;

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

    private String newMessageBuilder(String name, String msg) {
        return "New: " + msg + " from:" + name + "\n";
    }

    private String myMessageBuilder(String msg) {
        return "My: " + msg + " from:" + Storage.getInstance().getAppOwnerName() + "\n";
    }

    private void doHandleReceivedMessages(ASAPMessages asapMessages) {
        Log.d(this.getLogStart(), "going to handle received messages with uri: "
                + asapMessages.getURI());

        SerializableMessages serializableMessages = new SerializeMessages();
        StringBuilder builder = new StringBuilder();

        try {
            Iterator<byte[]> iterator = asapMessages.getMessages();

            while (iterator.hasNext()) {
                DataInputStream stream = serializableMessages.deserializer(iterator.next());
                String name = stream.readUTF();
                String msg = stream.readUTF();

                this.receivedMessages.add(newMessageBuilder(name, msg));
                Log.e("Debug", "Msg: " + msg + " from: " + name);
            }

            for (String msg : this.sentMessages) {
                builder.append(msg);
            }

            for (String msg : this.receivedMessages) {
                builder.append(msg);
            }
        } catch (IOException e) {
            Log.e("Error", "problems when handling received messages: "
                    + e.getLocalizedMessage());
            builder.append(e.getLocalizedMessage());
        }

        TextView receivedMessagesTV = findViewById(R.id.textViewForASAPMessenges);
        receivedMessagesTV.setMovementMethod(new ScrollingMovementMethod());
        Log.e("Debug", builder.toString());
        receivedMessagesTV.setText(builder.toString());
    }

    public void onClick(View view) {
        Log.e("Debug", "Press Send Btn");

        EditText messageEditView = findViewById(R.id.editTextNewMessage);
        Editable messageText = messageEditView.getText();

        boolean equaltext = true;

        if (!messageText.toString().equals(EXAMPLE_MESSAGE.toString()) && equaltext) {
            Log.d(this.getLogStart(), "going to send message: " + messageText);

            // asap messages are bytes
            SerializableMessages serializableMessages = new SerializeMessages();
            equaltext = false;

            //TODO WIP
            byte[] byteContent = serializableMessages.serializer(Storage.getInstance().getAppOwnerName(), messageText.toString());

            Log.d(this.getLogStart(), "going to send messageBytes: " + byteContent);

            this.sendMessage(byteContent);

            this.sentMessages.add(myMessageBuilder(messageText.toString()));
        }

        Toast toast = Toast.makeText(getApplication(), "Same Message change your text", Toast.LENGTH_SHORT);
        toast.show();
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
        Toast toast = Toast.makeText(getApplication(), "Start BluetoothDiscovery", Toast.LENGTH_SHORT);
        toast.show();
    }
}