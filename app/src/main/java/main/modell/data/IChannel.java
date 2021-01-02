package main.modell.data;

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
     * set Messages
     */
    void setMessage(List<INotification> notifications);

    /**
     * @return a list of recieved Msg
     */
    List<INotification> getMessages();

    /**
     * @return the status of the channel(1 active, 0 not available)
     */
    boolean getAlive();

    /**
     * URI e.g: asap://name, asap://myChannel
     * @return a URI
     */
    String getUri();
}
