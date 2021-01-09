package main.modell.storage;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.modell.data.IChannel;
import main.modell.data.INotification;

class StorageNotification implements IStorageNotification, Serializable {

    private List<INotification> notifications;

    public StorageNotification(List<INotification> notifications) {
        this.notifications = notifications;
    }

    @Override
    public void addNotification(INotification iNotification) {
        this.notifications.add(iNotification);
    }

    @Override
    public void addAllNotification(List<INotification> notifications) {
        this.notifications.addAll(notifications);
    }

    @Override
    public List<INotification> getNotificationList() {
        return this.notifications;
    }

    @Override
    public synchronized void removeNotification(String id) {
        INotification remove = null;

        for (INotification msg : this.notifications) {
            if (msg.getID().compareTo(id) == 0) {
                remove = msg;
            }
        }

        this.notifications.remove(remove);
    }

    @Override
    public String toString() {
        return "StorageNotification{" +
                "notifications=" + Arrays.toString(notifications.toArray()) +
                '}';
    }
}
