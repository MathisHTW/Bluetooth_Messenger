package main.modell.data;

import java.io.Serializable;

public class Notification implements INotification, Serializable {

    private final String ID;

    private final String name;

    public Notification() {
        this.ID = "-1";
        this.name = "Notification";
    }

    public Notification(String name) {

        if (null == name) {
            throw new NullPointerException("Name is null");
        }

        this.name = name;
        this.ID = Ultis.generatID(name);
    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

}
