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

    private static Storage instance = null;

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

    private static boolean hasName = false;
    private static IUser appOwnerName = null;

    private List<IUser> userList;
    private List<IChannel> channelList;
    private List<INotification> notificationList;
    
    private Storage() {
        this.userList = new LinkedList<>();
        this.channelList = new LinkedList<>();
        this.notificationList = new ArrayList<>();
    }

    public IUser getAppOwnerName() {
        return appOwnerName;
    }

    public void setAppOwnerName(IUser appOwnerName) {
        Storage.appOwnerName = appOwnerName;
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
    public static boolean hasName() {
        return null != appOwnerName;
    }

    public void clear() {
        this.userList = new LinkedList<>();
        this.channelList = new LinkedList<>();
        this.notificationList = new ArrayList<>();
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
