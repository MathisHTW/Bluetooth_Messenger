package main.modell.storage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.modell.data.IChannel;
import main.modell.data.INotification;
import main.modell.data.IUser;

class Storage {

    private List<IUser> userList;
    private List<IChannel> channelList;
    private List<INotification> notificationList;

    public Storage() {
        this.userList = new LinkedList<>();
        this.channelList = new LinkedList<>();
        this.notificationList = new ArrayList<>();
    }

    public void addUser(IUser iUser) {
        this.userList.add(iUser);
    }

    public void addChannelList(IChannel iChannel) {
        this.channelList.add(iChannel);
    }

    public void addNotification(INotification iNotification) {
        this.notificationList.add(iNotification);
    }

    public void clear() {
        this.userList = null;
        this.channelList = null;
        this.notificationList = null;
    }
}
