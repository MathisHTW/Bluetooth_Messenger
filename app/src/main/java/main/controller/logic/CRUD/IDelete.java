package main.controller.logic.CRUD;

import main.modell.data.IChannel;
import main.modell.data.INotification;
import main.modell.data.IUser;

public interface IDelete {

    /**
     * Delete a Channel and remove this from storage
     *
     * @param iChannel
     */
    boolean deleteChannel(IChannel iChannel);

    /**
     * Delete a User and remove this from storage
     *
     * @param iUser
     */
    boolean deleteUser(IUser iUser);

    /**
     * Delete a Message
     * @param iNotification
     * @return
     */
    boolean deleteMessage(INotification iNotification);
}
