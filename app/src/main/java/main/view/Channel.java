package main.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

import main.R;
import main.controller.asap.BTRootActivity;
import main.controller.AppController;
import main.modell.data.IChannel;
import main.modell.storage.Storage;
import main.modell.storage.StorageAsSingelton;

public class Channel extends BTRootActivity {

    private AppController appController = AppController.instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appController.onActivityCreated(this, savedInstanceState);

        setContentView(R.layout.activity_channel);

        ListView listView = (ListView) findViewById(R.id.ItemViewList);
        TextView textView = (TextView) findViewById(R.id.textViewID);

        Storage storage = StorageAsSingelton.getIntance();

        LinkedList<IChannel> listItem = new LinkedList<>();

        for (IChannel iChannel : storage.getChannelList()) {
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

    @Override
    protected void onStart() {
        super.onStart();
        appController.onActivityStarted(this);
    }
}