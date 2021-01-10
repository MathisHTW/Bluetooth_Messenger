package main.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import main.R;
import main.Start;
import main.controller.AppController;
import main.controller.logic.CRUD.Create;
import main.controller.logic.CRUD.Delete;
import main.modell.data.User;
import main.modell.storage.Storage;

public class Settings extends AppCompatActivity {

    private AppController appController = AppController.instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        this.initEvents();
        TextView textView = findViewById(R.id.editTextOwnerName);
        textView.setText(Storage.getInstance().getAppOwnerName().getName());
        appController.onActivityCreated(this, savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        appController.onActivityStarted(this);
    }

    private void initEvents() {


        this.deleteByChannel();
        this.deleteAppOwner();


        Button delete = findViewById(R.id.deleteAll);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Delete delete = new Delete();
                delete.deleteAll();
                Log.d("Settings", "Delete all Settings");

                Toast toast = Toast.makeText(getApplication(), "Your has delete all Settings", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private void deleteAppOwner() {
        Button add = findViewById(R.id.btnAppOwner);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.editTextOwnerName);

                //TODO call a exception better für testablitiy
                if (textView.getText().length() == 0) {
                    TextView view = findViewById(R.id.textViewErrorBySettings);
                    view.setText("Error Input was Empty");
                    view.setBackgroundColor(Color.RED);
                    return;
                }

                Storage.getInstance().setAppOwnerName(new User(textView.getText().toString()));

                Log.d("Settings", "Settings View add Username");
                Log.d("Settings", Storage.getInstance().getAppOwnerName().getName());

                Toast toast = Toast.makeText(getApplication(), "Your has change your Username", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private void deleteByChannel() {
        Button deleteChannelByName = findViewById(R.id.btnDeleteChannel);
        deleteChannelByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.editTextDeleteChannel);
                String text = textView.getText().toString();

                //TODO call a exception better für testablitiy
                if (text.isEmpty()) {
                    TextView view = findViewById(R.id.textViewErrorBySettings);
                    view.setText("Error Input was Empty");
                    view.setBackgroundColor(Color.RED);
                    return;
                }

                Log.d("Settings", "Remove Channel: " + text);
                Delete delete = new Delete();
                delete.deleteChannel(text);

                Toast toast = Toast.makeText(getApplication(), "Your has deleted Channel: " + text, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.appController.onActivityDestroyed(this);
    }
}