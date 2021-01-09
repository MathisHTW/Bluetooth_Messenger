package main.modell.storage;

import java.util.List;

import main.modell.data.INotification;

interface IStorageNotification {

    /**
     * Add a Notification
     *
     * @param iNotification
     */
    void addNotification(INotification iNotification);

    /**
     * Add list of Notification
     *
     * @param notifications
     */
    void addAllNotification(List<INotification> notifications);

    /**
     * Get list of Notification
     *
     * @return list
     */
    List<INotification> getNotificationList();


    /**
     * Remove a notification
     *
     * @param id
     */
    void removeNotification(String id);
}
