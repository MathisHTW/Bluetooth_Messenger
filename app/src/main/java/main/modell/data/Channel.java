package main.modell.data;

import java.util.List;

public class Channel implements IChannel {

    private String id;

    private String name;

    private List<IUser> userList;

    public Channel(String id, String name, List<IUser> userList) {
        this.id = id;
        this.name = name;
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userList=" + userList +
                '}';
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public List<IUser> getUserList() {
        return this.userList;
    }
}
