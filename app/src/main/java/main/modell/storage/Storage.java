package main.modell.storage;

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

public class Storage implements Serializable, IStorageChannel, IStorageNotification, IStorageUser {

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

    private IStorageUser storageUser;
    private IStorageChannel storageChannel;
    private IStorageNotification storageNotification;

    private Storage() {
        this.storageChannel = new StorageChannel(new LinkedList<IChannel>());
        this.storageNotification = new StorageNotification(new ArrayList<INotification>());
        this.storageUser = new StorageUser(new LinkedList<IUser>());

        this.storageUser.setAppOwnerName(new User(DEFAULT_APP_USERNAME));
    }

    public void addAllChannelList(List<IChannel> list) {
        this.storageChannel.addAllChannelList(list);
    }

    public void addChannelList(IChannel iChannel) {
        this.storageChannel.addChannelList(iChannel);
    }

    public void removeChannel(String name) {
        this.storageChannel.removeChannel(name);
    }

    public List<IChannel> getChannelList() {
        return this.storageChannel.getChannelList();
    }

    public void addNotification(INotification iNotification) {
        this.storageNotification.addNotification(iNotification);
    }

    public void addAllNotification(List<INotification> notifications) {
        this.storageNotification.addAllNotification(notifications);
    }

    public List<INotification> getNotificationList() {
        return this.storageNotification.getNotificationList();
    }

    public IUser getAppOwnerName() {
        return this.storageUser.getAppOwnerName();
    }

    public void setAppOwnerName(IUser appOwnerName) {
        this.storageUser.setAppOwnerName(appOwnerName);
    }

    public void addUser(IUser iUser) {
        this.storageUser.addUser(iUser);
    }

    public void addAllUser(List<IUser> iUsers) {
        this.storageUser.addAllUser(iUsers);
    }

    public void removeUser(String id) {
        this.storageUser.removeUser(id);
    }

    public List<IUser> getUserList() {
        return this.storageUser.getUserList();
    }

    public void clear() {

        this.storageNotification = null;
        this.storageChannel = null;
        this.storageUser = null;

        this.storageChannel = new StorageChannel(new LinkedList<IChannel>());
        this.storageNotification = new StorageNotification(new ArrayList<INotification>());
        this.storageUser = new StorageUser(new LinkedList<IUser>());

        this.addChannelList(new Channel("Public"));
        this.setAppOwnerName(new User(DEFAULT_APP_USERNAME));
    }

    @Override
    public String toString() {
        return "Storage{" +
                ", " + this.storageUser.toString() +
                ", " + this.storageNotification.toString() +
                ", " + this.storageChannel.toString() +
                '}';
    }
}
