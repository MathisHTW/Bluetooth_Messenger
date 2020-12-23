package main.modell.data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Channel implements IChannel, Serializable {

    private final String id;

    private final String name;

    private List<INotification> notifications;

    private final String uriASAP = "asap://";

    private final String uri;

    private boolean alive;

    public Channel() {
        this.id = "-1";
        this.name = "Dummy";
        this.uri = uriASAP + this.id;
    }

    public Channel(String name) {
        this.id = Ultis.generatID(name);
        this.name = name;
        this.uri = uriASAP + this.name;
    }

    public Channel(String name, List<INotification> notifications) {
        this.id = Ultis.generatID(name);
        this.name = name;
        this.notifications = notifications;
        this.uri = uriASAP + this.name;
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
