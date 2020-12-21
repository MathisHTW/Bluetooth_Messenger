package main.controller.asap;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import main.Start;

public class BTInit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BTApplication.applicationInstance(this);

        // launch real first activity
        this.finish();
        Intent intent = new Intent(this, Start.class);
        this.startActivity(intent);
    }
}