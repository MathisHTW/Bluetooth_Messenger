package main.modell.data;

import java.util.LinkedList;
import java.util.List;

public class Channel implements IChannel {

    private final String id ;

    private final String name;

    private List<IUser> userList;

    private boolean alive;

    public Channel() {
        this.id = "-1";
        this.name = "Dummy";
        this.userList = new LinkedList<>();
        this.userList.add(new User( "Paul"));
    }

    public Channel(String name){
        this.id = "id"; //TODO add ID generator
        this.name = name;
    }

    public Channel(String name, List<IUser> userList) {
        this.id = "id"; //TODO add ID generator
        this.name = name;
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userList=" + userList + '\'' +
                ", alive = " + alive +
                '}';
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
    public boolean getAlive(){ return this.alive; }
}
