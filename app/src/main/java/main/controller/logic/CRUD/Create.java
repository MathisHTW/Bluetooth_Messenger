package main.controller.logic.CRUD;

import android.util.Log;

import java.util.Date;

import main.modell.data.Channel;
import main.modell.data.IChannel;
import main.modell.data.INotification;
import main.modell.data.IUser;
import main.modell.data.Message;
import main.modell.data.User;
import main.modell.storage.Storage;

public class Create implements ICreate {

    private Storage storage;

    public Create() {
        this.storage = Storage.getInstance();
    }

    @Override
    public boolean createChannel(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            Log.e("Create", "Name is Empty");
            throw new IllegalArgumentException("Name is Empty");
        }

        boolean result = this.checkChannelAreDuplicated(name);

        if (result) {
            Log.e("Create", "Channel is not unique");
            throw new IllegalStateException("Channel is not unique");
        }

        final IChannel iChannel = new Channel(name);
        this.storage.addChannelList(iChannel);

        //Log.i("Debug", "Channel was been create | Name" + name);
        return true;
    }

    @Override
    public boolean createToUserList(String name) {
        final IUser iUser = new User(name);
        this.storage.addUser(iUser);

        Log.e("Debug", "User was been created | Name" + name);
        return true;
    }

    @Override
    public boolean createMessage(String name, String text) {
        final INotification notification = new Message(name, text);
        this.storage.addNotification(notification);

        Log.i("Debug", "Notification was been created");
        return true;
    }

    @Override
    public boolean createUser(String name) {
        final IUser iUser = new User(name);
        this.storage.setAppOwnerName(iUser);

        Log.i("Debug", "Create a appOwnerName");
        return true;
    }

    /**
     * Check if duplication name in Channel ist
     *
     * @param name
     * @return if true duplication or false unique
     */
    private boolean checkChannelAreDuplicated(String name) {
        for (IChannel channel : this.storage.getChannelList()) {
            if (channel.getName().toLowerCase().compareTo(name.toLowerCase()) == 0) {
                return true;
            }
        }
        return false;
    }
}
