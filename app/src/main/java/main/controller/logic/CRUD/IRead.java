package main.controller.logic.CRUD;

import android.content.Context;

import java.util.List;

import main.modell.data.IChannel;
import main.modell.data.INotification;
import main.modell.data.IUser;

public interface IRead {

    /**
     * Load serial storage
     *
     * @param context
     */
    void localStorage(Context context);

    /**
     * Get List of Channel
     * @return
     */
    List<IChannel> getChannels();

    /**
     * Get IUser of App Owner
     * @return
     */
    IUser getAppOwner();
}
