package main.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import main.controller.asap.ASAPActivity;
import main.controller.asap.ASAPApplication;

public class Channel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ASAPApplication.applicationInstance(this);

        this.finish();
        Intent intent = new Intent(this, ASAPActivity.class);
        this.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}