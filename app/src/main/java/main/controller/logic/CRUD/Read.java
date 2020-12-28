package main.controller.logic.CRUD;

import android.content.Context;
import android.util.Log;

import java.util.Objects;

import main.controller.logic.stream.localStorage.LocalStorage;
import main.modell.storage.Storage;

public class Read {

    private Storage storage;

    public Read() {
        this.storage = Storage.getIntance();
    }

    public void localStorage(Context context) {
        final LocalStorage localStorage = new LocalStorage();
        try {
            Storage storage = Storage.getIntance();
            Storage save = localStorage.read(context);

            if (!save.getChannelList().isEmpty()) {
                storage.addAllChannelList(save.getChannelList());
            }

            if (!save.getNotificationList().isEmpty()) {
                storage.addAllNotification(save.getNotificationList());
            }

            if (!save.getUserList().isEmpty()) {
                storage.addAllUser(save.getUserList());
            }

        } catch (NullPointerException e) {
            Log.i("Save", Objects.requireNonNull(e.getMessage()));
        }
    }

}
