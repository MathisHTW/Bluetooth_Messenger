package main.controller.asap.example;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import net.sharksystem.asap.ASAPEngineFS;
import net.sharksystem.asap.ASAPException;
import net.sharksystem.asap.ASAPStorage;

import java.io.IOException;

import main.controller.asap.ASAPApplication;

/*
class asapStoreTest {

    ///////////////////////////////////////////////////////////////////////////////////////////
    //                              asap store test scenario(s)                              //
    ///////////////////////////////////////////////////////////////////////////////////////////

    private final String URI = "sn://chat";
    private final String MESSAGE = "Hi, that's a message";
    private final byte[] BYTE_MESSAGE = MESSAGE.getBytes();

    ASAPStorage asapStorage;

    public void onSetupCleanASAPStorageClick(View view) {
        try {
            this.setupCleanASAPStorage();
        } catch (IOException | ASAPException e) {
            Log.d(this.getLogStart(), "exception: " + e.getLocalizedMessage());
        } catch (RuntimeException e) {
            Log.d(this.getLogStart(), "runtime exception: " + e.getLocalizedMessage());
        }
    }

    public void onSwitch2ExchangeActivity(View view) {
        this.startActivity(new Intent(this, ASAPMessagingActivity.class));
    }

    private void setupCleanASAPStorage() throws IOException, ASAPException {
        String absoluteFolderName = this.getASAPApplication().getApplicationRootFolder(ASAPApplication.ASAP_Messenger);
        Log.d(this.getLogStart(), "going to clean folder:  " + absoluteFolderName);

        ASAPEngineFS.removeFolder(absoluteFolderName);

        Log.d(this.getLogStart(), "create asap storage with:  "
                + this.getASAPApplication().getOwnerID()
                + " | "
                + this.getASAPApplication().getApplicationRootFolder(ASAPApplication.ASAP_Messenger)
                + " | "
                + ASAPApplication.ASAP_Messenger
        );

        this.asapStorage = ASAPEngineFS.getASAPStorage(
                this.getASAPApplication().getOwnerID().toString(),
                this.getASAPApplication().getApplicationRootFolder(ASAPApplication.ASAP_Messenger),
                ASAPApplication.ASAP_Messenger);
    }

    public void onAddOnlineSenderClick(View view) {
        Log.d(this.getLogStart(), "onAddOnlineSenderClick reached");
        Log.d(this.getLogStart(), "TODO: implement");
    }

    public void onRemoveAddOnlineSenderClick(View view) {
        Log.d(this.getLogStart(), "onRemoveAddOnlineSenderClick reached");
        Log.d(this.getLogStart(), "onAddOnlineSenderClick reached");
    }

    private void checkStorage() throws IOException, ASAPException {
        if (this.asapStorage == null) {
            Log.d(this.getLogStart(), "storage not yet initialized - clean and setup:  " + MESSAGE);
            this.setupCleanASAPStorage();
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    //                                         helps debugging                               //
    ///////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void asapNotifyBTDiscoverableStopped() {
        super.asapNotifyBTDiscoverableStopped();
        Log.d(this.getLogStart(), "got notified: discoverable stopped");
        Toast.makeText(this, "discoverable stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void asapNotifyBTDiscoveryStopped() {
        super.asapNotifyBTDiscoveryStopped();
        Log.d(this.getLogStart(), "got notified: discovery stopped");
        Toast.makeText(this, "discovery stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void asapNotifyBTDiscoveryStarted() {
        super.asapNotifyBTDiscoveryStarted();
        Log.d(this.getLogStart(), "got notified: discovery started");
        Toast.makeText(this, "discovery started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void asapNotifyBTDiscoverableStarted() {
        super.asapNotifyBTDiscoverableStarted();
        Log.d(this.getLogStart(), "got notified: discoverable started");
        Toast.makeText(this, "discoverable started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void asapNotifyBTEnvironmentStarted() {
        super.asapNotifyBTEnvironmentStarted();
        Log.d(this.getLogStart(), "got notified: bluetooth on");
        Toast.makeText(this, "bluetooth on", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void asapNotifyBTEnvironmentStopped() {
        super.asapNotifyBTEnvironmentStopped();
        Log.d(this.getLogStart(), "got notified: bluetooth off");
        Toast.makeText(this, "bluetooth off", Toast.LENGTH_SHORT).show();
    }


}

 */
