package main.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;

import main.R;
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

        LinkedList<String> listItem = new LinkedList<>();
        listItem.add("Name");
        listItem.add("NICE");

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
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