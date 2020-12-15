package main.modell.storage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.modell.data.IChannel;
import main.modell.data.INotification;
import main.modell.data.IUser;

public class Storage {

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

    public void removeUser(String id) {

        IUser removeUser = null;

        for (IUser iUser : this.userList) {
            if (iUser.getID().compareTo(id) == 0) {
                removeUser = iUser;
            }
        }

        this.userList.remove(removeUser);
    }

    public void removeChannel(String id) {

        IChannel removeChannel = null;

        for (IChannel iChannel : this.channelList) {
            if (iChannel.getID().compareTo(id) == 0) {
                removeChannel = iChannel;
            }
        }

        this.channelList.remove(removeChannel);
    }

    public List<IUser> getUserList() {
        return userList;
    }

    public List<IChannel> getChannelList() {
        return channelList;
    }

    public List<INotification> getNotificationList() {
        return notificationList;
    }

    public void clear() {
        this.userList = null;
        this.channelList = null;
        this.notificationList = null;
    }
}
