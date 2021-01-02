package main.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import main.R;
import main.Start;
import main.controller.AppController;
import main.controller.logic.CRUD.Create;
import main.modell.data.User;
import main.modell.storage.Storage;

public class Settings extends AppCompatActivity {

    private AppController appController = AppController.instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        appController.onActivityCreated(this, savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        appController.onActivityStarted(this);
    }

    public void onClick(View view) {
        TextView textView = findViewById(R.id.editTextOwnerName);
        Storage.getInstance().setAppOwnerName(new User(textView.getText().toString()));

        Log.d("Settings", "Settings View add Username");
        Log.d("Settings", Storage.getInstance().getAppOwnerName().getName());

        Toast toast = Toast.makeText(getApplication(), "Your has change your Username", Toast.LENGTH_SHORT);
        toast.show();
        //startActivity(new Intent(this, Channel.class));
    }
}