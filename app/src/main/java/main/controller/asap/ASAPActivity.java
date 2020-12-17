package main.controller.asap;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import net.sharksystem.asap.ASAPException;
import net.sharksystem.asap.ASAPMessages;
import net.sharksystem.asap.android.apps.ASAPMessageReceivedListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.R;

public class ASAPActivity extends ASAPRootActivity {

    private static final CharSequence URI = "asap://exampleURI";
    private static final CharSequence EXAMPLE_MESSAGE = "ASAP example message";
    private ASAPMessageReceivedListener receivedListener;
    private List<String> sentMessages = new ArrayList<>();
    private List<String> receivedMessages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_s_a_p);
        TextView textView = findViewById(R.id.textViewChannelName);
        textView.setText("ASPA has been started");

        if (!this.isBluetoothEnvironmentOn()) {
            Log.d(this.getLogStart(), "start bt button pressed - ask service to start bt");
            super.startBluetooth();
        }

        //TODO add gui for R.id.URL
        // TextView uriTextView = findViewById(R.id.exampleMessagingUri);

        // uriTextView.setText("your owner id: " + this.getASAPApplication().getOwnerID()
        //         + "channel URI: " + URI);

        EditText messageEditView = findViewById(R.id.editTextNewMessage);
        messageEditView.setText(EXAMPLE_MESSAGE);

        this.receivedListener = new ASAPMessageReceivedListener() {
            @Override
            public void asapMessagesReceived(ASAPMessages asapMessages) {
                Log.d(getLogStart(), "asapMessageReceived");
                ASAPActivity.this.doHandleReceivedMessages(asapMessages);
                Log.e("Debug", asapMessages.toString());
            }
        };

        // set listener to get informed about newly arrived messages
        this.getASAPApplication().addASAPMessageReceivedListener(
                ASAPApplication.ASAP_Messenger, // listen to this app
                this.receivedListener
        );

    }

    public void sendMessage(byte[] byteContent) {
        try {
            this.sendASAPMessage(
                    ASAPApplication.ASAP_Messenger,
                    URI,
                    byteContent,
                    true);
        } catch (ASAPException e) {
            Log.e(this.getLogStart(), "when sending asap message: " + e.getLocalizedMessage());
        }
    }

    /*
    @Override
    protected void onRestart() {
        super.onRestart();
        super.startBluetooth();
    }

    @Override
    protected void onPause() {
        super.onPause();
        super.stopBluetooth();
    }
     */

    @Override
    protected void onStop() {
        super.onStop();
        super.stopBluetooth();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        super.stopBluetooth();
        this.getASAPApplication().removeASAPMessageReceivedListener(
                ASAPApplication.ASAP_Messenger,
                this.receivedListener
        );
    }

    private void doHandleReceivedMessages(ASAPMessages asapMessages) {
        Log.d(this.getLogStart(), "going to handle received messages with uri: "
                + asapMessages.getURI());

        // set up output
        StringBuilder sb = new StringBuilder();

        try {
            Iterator<CharSequence> messagesAsCharSequence = asapMessages.getMessagesAsCharSequence();
            sb.append("new messages:\n");
            while (messagesAsCharSequence.hasNext()) {
                String receivedMessage = messagesAsCharSequence.next().toString();
                this.receivedMessages.add(receivedMessage);
                sb.append(receivedMessage);
            }
            sb.append("your messages: \n");
            for (String msg : this.sentMessages) {
                sb.append(msg);
                sb.append("\n");
            }
            sb.append("received messages: \n");
            for (String msg : this.receivedMessages) {
                sb.append(msg);
            }
        } catch (IOException e) {
            Log.e("Error", "problems when handling received messages: "
                    + e.getLocalizedMessage());
            sb.append(e.getLocalizedMessage());
        }

        TextView receivedMessagesTV = this.findViewById(R.id.textViewForASAPMessenges);
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

    public void onClickBluetooth(View view) {
        super.startBluetoothDiscovery();
        super.startBluetoothDiscoverable();
    }

    /*
    public void asapNotifyOnlinePeersChanged(List<CharSequence> onlinePeerList) {
        super.asapNotifyOnlinePeersChanged(onlinePeerList);

        TextView peerListTextView = this.findViewById(R.id.onlinePeersList);

        if (onlinePeerList == null || onlinePeerList.size() < 1) {
            peerListTextView.setText("no peers online");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("peers online:");
            sb.append("\n");
            for (CharSequence peerID : onlinePeerList) {
                sb.append("id: ");
                sb.append(peerID);
                sb.append("\n");
            }
            peerListTextView.setText(sb.toString());
        }
        peerListTextView.refreshDrawableState();
    }
    */

}