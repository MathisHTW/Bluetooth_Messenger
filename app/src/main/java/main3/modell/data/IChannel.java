package main3.modell.data;

import java.util.List;

public interface IChannel {

    /**
     * @return the unique ID of the channel
     */
    String getID();

    /**
     * @return the Name of the channel
     */
    String getName();

    /**
     * @return the List of users in this channel
     */
    List<IUser> getUserList();

    /**
     * @return the status of the channel(1 active, 0 not available)
     */
    boolean getAlive();

}
