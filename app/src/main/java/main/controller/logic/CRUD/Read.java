package main.controller.logic.CRUD;

import android.content.Context;
import android.util.Log;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import main.controller.logic.stream.localStorage.LocalStorage;
import main.modell.data.Channel;
import main.modell.data.IChannel;
import main.modell.data.INotification;
import main.modell.data.IUser;
import main.modell.data.Message;
import main.modell.storage.Storage;

public class Read implements IRead {

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

            if (save.getChannelList().size() == 0) {
                this.storage.addChannelList(new Channel(Storage.DEFAULT_CHANNEL_NAME));
            }

            if (!save.getUserList().isEmpty()) {
                this.storage.addAllUser(save.getUserList());
            }


        } catch (NullPointerException e) {
            Log.i("Save", Objects.requireNonNull(e.getMessage()));
        }
    }

    @Override
    public List<IChannel> getChannels() {
        return this.storage.getChannelList();
    }

    @Override
    public IUser getAppOwner() {
        return this.storage.getAppOwnerName();
    }


}
