package main.controller.logic.CRUD;

import android.content.Context;
import android.util.Log;

import java.util.Objects;

import main.controller.logic.stream.localStorage.LocalStorage;
import main.modell.storage.Storage;

public class Read {

    private Storage storage;

    public Read() {
        this.storage = Storage.getInstance();
    }

    public void localStorage(Context context) {
        final LocalStorage localStorage = new LocalStorage();
        try {
            Storage save = localStorage.read(context);

            if (!save.getChannelList().isEmpty()) {
                this.storage.addAllChannelList(save.getChannelList());
            }

            if (!save.getUserList().isEmpty()) {
                this.storage.addAllUser(save.getUserList());
            }

            if (save.getAppOwnerName() != null) {
                this.storage.setAppOwnerName(save.getAppOwnerName());
            }

        } catch (NullPointerException e) {
            Log.i("Save", Objects.requireNonNull(e.getMessage()));
        }
    }

}
