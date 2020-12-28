package main.modell.data;

import java.io.Serializable;

public class User implements IUser, Serializable {

    private String name;
    private final String id;

    public User() {
        this.id = "-1";
        this.name = "Dummy";
    }

    public User(String name) {

        if (null == name || name.isEmpty()) {
            throw new NullPointerException("Name is null or Empty");
        }

        this.name = name;
        this.id = Ultis.generatID(name);
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
    public String toString() {
        return name;
    }
}
