package main.modell.storage;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

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
        return null;
    }

    @Override
    public String toString() {
        return "StorageNotification{" +
                "notifications=" + Arrays.toString(notifications.toArray()) +
                '}';
    }
}
