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
import java.util.LinkedList;
import java.util.List;

import main.R;
import main.controller.asap.BTApplication;
import main.controller.asap.BTRootActivity;
import main.controller.AppController;
import main.controller.logic.CRUD.Read;
import main.controller.logic.stream.SerializableMessages;
import main.controller.logic.stream.SerializeMessages;
import main.modell.data.INotification;
import main.modell.data.Message;
import main.modell.data.User;
import main.modell.storage.Storage;

public class CurrentChannel extends BTRootActivity {

    private AppController appController = AppController.instance;

    private static final CharSequence EXAMPLE_MESSAGE = "Send a Msg";

    private final Storage storage;
    private String name;
    private String id;
    private CharSequence uri;
    private int selectChannel;

    private ASAPMessageReceivedListener receivedListener;
    private List<String> sentMessages = new ArrayList<>();
    private List<String> receivedMessages = new ArrayList<>();
    private List<INotification> notifications = new LinkedList<>();

    public CurrentChannel() {
        this.storage = Storage.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_s_a_p);
        this.appController.onActivityCreated(this, savedInstanceState);

        this.init();
        this.initASAP();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.appController.onActivityResumed(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.saveNotification();
        this.appController.onActivityPaused(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //this.saveNotification();
        this.appController.onActivityStopped(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //this.saveNotification();
        this.appController.onActivityDestroyed(this);
    }

    private void init() {
        //Get Information about ID, name, URI
        Log.d("CurrentChannel", "Bundle is loaded");
        this.selectChannel = getIntent().getExtras().getInt("ID");
        this.name = this.storage.getChannelList().get(selectChannel).getName();
        this.id = this.storage.getChannelList().get(selectChannel).getID();
        this.uri = this.storage.getChannelList().get(selectChannel).getUri();
        Log.i("Channel", "Name of Channel: " + this.name);
        Log.i("Channel", "Id of Channel: " + this.id);

        //TODO add Senden Messages
        TextView textView = findViewById(R.id.textViewChannelName);
        textView.setText("ChannelName=" + this.name);

        EditText messageEditView = findViewById(R.id.editTextNewMessage);
        messageEditView.setText(EXAMPLE_MESSAGE);

        //TODO is not more usefull
        //this.readNotification();
    }

    private void initASAP() {
        /**
         Check Bluetooth is on
         */
        if (!this.isBluetoothEnvironmentOn()) {
            Log.d(this.getLogStart(), "start bt button pressed - ask service to start bt");
            super.startBluetooth();
        }

        /**
         * Create Listener
         */
        this.receivedListener = new ASAPMessageReceivedListener() {
            @Override
            public void asapMessagesReceived(ASAPMessages asapMessages) {
                Log.d("receivedListener", "asapMessageReceived");
                CurrentChannel.this.doHandleReceivedMessages(asapMessages);
                Log.e("receivedListener", asapMessages.toString());
            }
        };

        /**
         * set listener to get informed about newly arrived messages
         */
        this.getASAPApplication().addASAPMessageReceivedListener(
                BTApplication.ASAP_Messenger, // listen to this app
                this.receivedListener
        );
    }

    /**
     * After close app save current messages
     */
    private void saveNotification() {
        Storage.getInstance().getChannelList().get(this.selectChannel).setMessage(this.notifications);
    }

    private void readNotification() {
        TextView textView = findViewById(R.id.textViewForASAPMessenges);

        StringBuilder stringBuilder = new StringBuilder();

        List<INotification> notifications = Storage.getInstance().getChannelList().get(selectChannel).getMessages();
        if (notifications != null) {
            for (INotification notification : notifications) {
                stringBuilder.append(notification.getName() + " " + notification.getText() + "\n");
            }

            textView.setText(stringBuilder.toString());
        } else {
            textView.setText("No Messages");
        }

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
                this.notifications.add(new Message(Storage.getInstance().getAppOwnerName().getName(), msg));
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


        Log.d(this.getLogStart(), "going to send message: " + messageText);

        // asap messages are bytes
        SerializableMessages serializableMessages = new SerializeMessages();
        equaltext = false;

        //TODO WIP
        byte[] byteContent = serializableMessages.serializer(Storage.getInstance().getAppOwnerName(), messageText.toString());

        Log.d(this.getLogStart(), "going to send messageBytes: " + byteContent);

        this.sendMessage(byteContent);

        this.sentMessages.add(myMessageBuilder(messageText.toString()));
        this.notifications.add(new Message(Storage.getInstance().getAppOwnerName().getName(), messageText.toString()));

        /*
        Toast toast = Toast.makeText(getApplication(), "Same Message change your text", Toast.LENGTH_SHORT);
        toast.show();

         */
    }

    private void sendMessage(byte[] byteContent) {
        try {
            this.sendASAPMessage(
                    BTApplication.ASAP_Messenger,
                    uri,
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