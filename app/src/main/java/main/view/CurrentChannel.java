package main.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import main.controller.asap.ASAPActivity;
import main.controller.asap.ASAPApplication;

public class CurrentChannel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ASAPApplication.applicationInstance(this);
        this.finish();
        Intent intent = new Intent(this, ASAPActivity.class);
        this.startActivity(intent);
    }

    /**called when user taps the send it button*/
    public void sendMessage(View view){

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}