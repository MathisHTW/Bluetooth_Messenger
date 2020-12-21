package main.modell.data;

import java.io.Serializable;

public class Notification implements INotification, Serializable {

    private String ID;

    private String name;

    public Notification(String name) {
        new Notification(Ultis.generatID(name), name);
    }

    Notification(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

}
