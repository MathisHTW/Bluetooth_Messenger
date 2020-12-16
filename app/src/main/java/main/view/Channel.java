package main.view;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import main.R;
import main.controller.asap.ASAPActivity;
import main.controller.asap.ASAPApplication;
import main.modell.data.IChannel;
import main.modell.storage.Storage;
import main.modell.storage.StorageAsSingelton;

public class Channel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_channel);

        ListView listView = (ListView) findViewById(R.id.ItemViewList);
        TextView textView = (TextView) findViewById(R.id.textViewID);

        Storage storage = StorageAsSingelton.getIntance();

        /*
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.get;

        List<String> s = new ArrayList<>();
        for (BluetoothDevice bt : pairedDevices) {
            s.add(bt.getName());
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                s
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent createChannel = new Intent(getApplicationContext(), CurrentChannel.class);
                startActivity(createChannel);
            }
        });
        */


        LinkedList<IChannel> listItem = new LinkedList<>();

        for (IChannel iChannel : storage.getChannelList()){
            listItem.add(iChannel);
        }

        final ArrayAdapter<IChannel> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                listItem
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent createChannel = new Intent(getApplicationContext(), CurrentChannel.class);
                startActivity(createChannel);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}