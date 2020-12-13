package main.controller.asap;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import net.sharksystem.asap.android.apps.ASAPActivity;

public class ASAPInit extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ASAPApplication.initializeASAPApplication(this);
        this.finish();
        Intent intent = new Intent(this, ASAPActivity.class);
        this.startActivity(intent);
        Log.i("ASAP", "ASAP has been started:");
    }

}
