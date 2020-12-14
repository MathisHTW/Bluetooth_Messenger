package main.controller.asap;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import main.R;

public class ASAPActivity extends ASAPRootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_channel);
        TextView textView = findViewById(R.id.debugASAPText);
        textView.setText("ASPA has been started");
    }

    public void onClick(View view) {
        View startBTButton = findViewById(R.id.startBT);
        View stopBTButton = findViewById(R.id.stopBT);

        if (view == startBTButton) {
            Log.d(this.getLogStart(), "start bt button pressed - ask service to start bt");
            super.startBluetooth();
        } else if (view == stopBTButton) {
            Log.d(this.getLogStart(), "stop bt button pressed - send message");
            super.stopBluetooth();
        } else if (view == findViewById(R.id.startDiscoverableAndDiscovery)) {
            Log.d(this.getLogStart(),
                    "start disoverable and discover button pressed - send messages");
            super.startBluetoothDiscovery();
            super.startBluetoothDiscoverable();
        }
    }

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
}