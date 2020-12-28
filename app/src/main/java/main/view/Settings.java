package main.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import main.R;
import main.Start;
import main.controller.logic.CRUD.Create;
import main.modell.storage.Storage;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void onClick(View view) {
        TextView textView = findViewById(R.id.editTextOwnerName);
        Create create = new Create();
        create.createUser(textView.getText().toString());

        Log.e("Debug", "Settings View add Username");

        startActivity(new Intent(this, Start.class));
    }
}