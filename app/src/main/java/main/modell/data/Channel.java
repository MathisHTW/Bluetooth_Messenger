package main.modell.data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Channel implements IChannel, Serializable {

    private final String id;

    private final String name;

    private List<IUser> userList;

    private List<INotification> notifications;

    private boolean alive;

    public Channel() {
        this.id = "-1";
        this.name = "Dummy";
        this.userList = new LinkedList<>();
        this.userList.add(new User("Paul"));
    }

    public Channel(String name) {
        this.id = Ultis.generatID(name);
        this.name = name;
    }

    public Channel(String name, List<IUser> userList) {
        this.id = Ultis.generatID(name);
        this.name = name;
        this.userList = userList;
    }

    public Channel(String name, List<IUser> userList, List<INotification> notifications) {
        this.id = Ultis.generatID(name);
        this.name = name;
        this.userList = userList;
        this.notifications = notifications;
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
    public List<IUser> getUserList() {
        return this.userList;
    }

    @Override
    public boolean getAlive() {
        return this.alive;
    }

    @Override
    public String toString() {
        return
                "id='" + id + '\'' +
                        ", name='" + name + '\'';
    }


}
