package main3.controller.logic.CRUD;

import main3.modell.data.IChannel;
import main3.modell.data.IUser;

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

}
