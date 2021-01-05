package main.modell.storage;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import main.modell.data.Channel;
import main.modell.data.IChannel;
import main.modell.data.INotification;
import main.modell.data.IUser;
import main.modell.data.User;

public class Storage implements Serializable {

    private static final long serialVersionUID = 211268099661671010L;

    private static Storage instance = null;

    public final static String DEFAULT_APP_USERNAME = "Unknown";
    public final static String DEFAULT_CHANNEL_NAME = "Public";

    /**
     * Get Storage Func
     *
     * @return Storage instance
     */
    public synchronized static Storage getInstance() {
        if (null == Storage.instance) {
            Storage.instance = new Storage();
        }
        return Storage.instance;
    }

    private IUser appOwnerName;

    private List<IUser> userList;
    private List<IChannel> channelList;
    private List<INotification> notificationList;

    private Storage() {
        this.userList = new LinkedList<>();
        this.channelList = new LinkedList<>();
        this.notificationList = new ArrayList<>();

        this.appOwnerName = new User(DEFAULT_APP_USERNAME);
    }

    public IUser getAppOwnerName() {
        return appOwnerName;
    }

    public void setAppOwnerName(IUser appOwnerName) {
        this.appOwnerName = appOwnerName;
    }

    public void addUser(IUser iUser) {
        this.userList.add(iUser);
    }

    public void addChannelList(IChannel iChannel) {
        Log.d("Storage", "Add new Channel size: " + this.channelList.size());
        this.channelList.add(iChannel);
    }

    public void addNotification(INotification iNotification) {
        this.notificationList.add(iNotification);
    }

    public void addAllChannelList(List<IChannel> list) {
        this.channelList.addAll(list);
    }

    public void addAllUser(List<IUser> iUsers) {
        this.userList.addAll(iUsers);
    }

    public void addAllNotification(List<INotification> notifications) {
        this.notificationList.addAll(notifications);
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

    public void removeChannel(String name) {

        IChannel removeChannel = null;

        for (IChannel iChannel : this.channelList) {
            if (iChannel.getName().compareTo(name) == 0) {
                removeChannel = iChannel;
            }
        }

        this.channelList.remove(removeChannel);
    }

    public List<IUser> getUserList() {
        return userList;
    }

    public List<IChannel> getChannelList() {
        Log.d("Storage", "Channelsize: " + this.channelList.size());
        return this.channelList;
    }

    public List<INotification> getNotificationList() {
        return notificationList;
    }

    public void clear() {
        this.userList = new LinkedList<>();
        this.channelList = new LinkedList<>();
        this.notificationList = new ArrayList<>();

        this.addChannelList(new Channel("Public"));
        this.setAppOwnerName(new User(DEFAULT_APP_USERNAME));
    }

    @Override
    public String toString() {
        return "Storage{" +
                "App Owner=" + this.getAppOwnerName() +
                ", userList=" + Arrays.toString(userList.toArray()) +
                ", channelList=" + Arrays.toString(channelList.toArray()) +
                ", notificationList=" + Arrays.toString(notificationList.toArray()) +
                '}';
    }
}
