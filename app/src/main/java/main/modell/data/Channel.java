package main.modell.data;

import java.io.Serializable;
import java.util.List;

public class Channel implements IChannel, Serializable {

    private final String id;

    private final String name;

    private List<INotification> notifications;

    public static final String URI_ASAP = "asap://";

    private final String uri;

    private boolean alive;

    /**
     * Create a Default Channel
     */
    public Channel() {
        this.id = "-1";
        this.name = "Dummy";
        this.uri = URI_ASAP + this.id;
    }

    public Channel(String name) {
        this.id = Ultis.generatID(name);
        this.name = name;
        this.uri = URI_ASAP + this.name;
    }

    /**
     * Create a Channel
     * @param name set a name
     * @param notifications set a list of sendet Messages
     */
    public Channel(String name, List<INotification> notifications) {
        this.id = Ultis.generatID(name);
        this.name = name;
        this.notifications = notifications;
        this.uri = URI_ASAP + this.name;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setMessage(List<INotification> notifications) {
        this.notifications = notifications;
    }

    @Override
    public List<INotification> getMessages() {
        return null;
    }

    @Override
    public boolean getAlive() {
        return this.alive;
    }

    @Override
    public String getUri() {
        return this.uri;
    }

    @Override
    public String toString() {
        return "Name=" + name;
    }

}
