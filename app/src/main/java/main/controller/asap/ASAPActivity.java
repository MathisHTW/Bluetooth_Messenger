package main.controller.asap;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bluetoothmessenger.R;

import java.util.List;

class ASAPActivity extends ASAPRootActivity {
    public ASAPActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO set GUI
        //setContentView();
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

        if(onlinePeerList == null || onlinePeerList.size() < 1) {
            peerListTextView.setText("no peers online");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("peers online:");
            sb.append("\n");
            for(CharSequence peerID : onlinePeerList) {
                sb.append("id: ");
                sb.append(peerID);
                sb.append("\n");
            }
            peerListTextView.setText(sb.toString());
        }
        peerListTextView.refreshDrawableState();
    }




    ///////////////////////////////////////////////////////////////////////////////////////////
    //                                         helps debugging                               //
    ///////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void asapNotifyBTDiscoverableStopped() {
        super.asapNotifyBTDiscoverableStopped();
        Log.d(this.getLogStart(), "got notified: discoverable stopped");
        Toast.makeText(this, "discoverable stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void asapNotifyBTDiscoveryStopped() {
        super.asapNotifyBTDiscoveryStopped();
        Log.d(this.getLogStart(), "got notified: discovery stopped");
        Toast.makeText(this, "discovery stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void asapNotifyBTDiscoveryStarted() {
        super.asapNotifyBTDiscoveryStarted();
        Log.d(this.getLogStart(), "got notified: discovery started");
        Toast.makeText(this, "discovery started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void asapNotifyBTDiscoverableStarted() {
        super.asapNotifyBTDiscoverableStarted();
        Log.d(this.getLogStart(), "got notified: discoverable started");
        Toast.makeText(this, "discoverable started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void asapNotifyBTEnvironmentStarted() {
        super.asapNotifyBTEnvironmentStarted();
        Log.d(this.getLogStart(), "got notified: bluetooth on");
        Toast.makeText(this, "bluetooth on", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void asapNotifyBTEnvironmentStopped() {
        super.asapNotifyBTEnvironmentStopped();
        Log.d(this.getLogStart(), "got notified: bluetooth off");
        Toast.makeText(this, "bluetooth off", Toast.LENGTH_SHORT).show();
    }
}
