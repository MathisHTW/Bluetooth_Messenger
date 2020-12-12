package main.controller.logic.CRUD;

import android.util.Log;

import main.modell.storage.Storage;
import main.modell.storage.StorageAsSingelton;

public class Create implements ICreate{

    private Storage storage;

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
}
