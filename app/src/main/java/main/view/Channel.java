package main.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import main.R;
import main.controller.asap.ASAPActivity;
import main.controller.asap.ASAPApplication;
import main.modell.storage.Storage;
import main.modell.storage.StorageAsSingelton;

public class Channel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        ASAPApplication.initializeASAPApplication(this);

        this.finish();
        Intent intent = new Intent(this, ASAPActivity.class);
        this.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final Storage storage = StorageAsSingelton.getIntance();
        this.buildChannels(storage);

    }

    /**
     * Create the view of current Channels
     *
     * @param storage
     */
    private void buildChannels(Storage storage) {

    }
}