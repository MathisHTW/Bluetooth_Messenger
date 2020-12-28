package main.modell.storage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import main.modell.data.IChannel;
import main.modell.data.INotification;
import main.modell.data.IUser;

public class Storage implements Serializable {

    private static final long serialVersionUID = 211268099661671010L;

    private volatile static Storage instance;

    /**
     * Get Storage Func
     * @return Storage instance
     */
    public synchronized static Storage getIntance() {
        if (null == instance) {
            instance = new Storage();
        }
        return instance;
    }

    private boolean hasName = true;

    private List<IUser> userList;
    private List<IChannel> channelList;
    private List<INotification> notificationList;

    private Storage() {
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

    /**
     * Check has User create a Username
     *
     * @return if true = found a name | false = not found a name
     */
    public boolean hasName() {

        if (this.userList.isEmpty() || this.userList.size() == 0) {
            this.hasName = false;
        }

        return hasName;
    }

    public void clear() {
        this.userList = null;
        this.channelList = null;
        this.notificationList = null;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "hasName=" + hasName +
                ", userList=" + Arrays.toString(userList.toArray()) +
                ", channelList=" + Arrays.toString(channelList.toArray()) +
                ", notificationList=" + Arrays.toString(notificationList.toArray()) +
                '}';
    }
}
