package main.controller.logic.CRUD;

import android.util.Log;

import java.util.Date;

import main.modell.storage.Storage;
import main.modell.storage.StorageAsSingelton;

public class Create implements ICreate{

    private Storage storage;
    private final int randomSize = 1000000;

    public Create() {
        this.storage = StorageAsSingelton.getIntance();
    }

    @Override
    public boolean createChannel(String name) {
        Log.e("Test", name + " | NCIE !!!!!!!!");
        return true;
    }

    @Override
    public boolean createUser(String name) {
        return true;
    }

    @Override
    public String createURI(String channelName){
        String myURI = "Bluetooth_Messenger://" + channelName;

        int random = (int)(Math.random() * randomSize);
        Date date = new Date();
        long timeInMillis = date.getTime();

        myURI = myURI + random;
        myURI = myURI + timeInMillis;

        return myURI;
    }
}
