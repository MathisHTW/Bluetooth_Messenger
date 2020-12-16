package main.controller.logic.CRUD;

import android.telecom.InCallService;
import android.util.Log;

import java.util.Date;
import java.util.List;

import main.modell.data.Channel;
import main.modell.data.IChannel;
import main.modell.data.IUser;
import main.modell.data.User;
import main.modell.storage.Storage;
import main.modell.storage.StorageAsSingelton;

public class Create implements ICreate {

    private Storage storage;
    private final int randomSize = 1000000;

    public Create() {
        this.storage = StorageAsSingelton.getIntance();
    }

    @Override
    public boolean createChannel(String name) {
        final IChannel iChannel = new Channel(name);
        this.storage.addChannelList(iChannel);

        Log.e("Debug", "Channel was been create | Name" + name);

        return true;
    }

    @Override
    public boolean createUser(String name) {
        final IUser iUser = new User(name);
        this.storage.addUser(iUser);

        Log.e("Debug", "User was been create | Name" + name);

        return true;
    }

    /**
     * creates a unique URI for this device to be used as a unique identifier of
     * the channel of this device
     * @param channelName the name of the channel that is entered into the UI
     * @return URI for this device
     */
    public String createURI(String channelName) {
        String myURI = "Bluetooth_Messenger://" + channelName;

        int random = (int) (Math.random() * randomSize);
        Date date = new Date();
        long timeInMillis = date.getTime();

        myURI = myURI + random;
        myURI = myURI + timeInMillis;

        return myURI;
    }
}
