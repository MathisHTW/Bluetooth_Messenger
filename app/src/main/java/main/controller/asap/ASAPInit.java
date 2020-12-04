package main.controller.asap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import net.sharksystem.asap.android.apps.ASAPActivity;

public class ASAPInit extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ASAPApplication.initializeASAPApplication(this);
        this.finish();
        Intent intent = new Intent(this, ASAPActivity.class);
        this.startActivity(intent);
    }
}
