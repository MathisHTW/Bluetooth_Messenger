package main.modell.data;

import java.io.Serializable;

public class Notification implements INotification, Serializable {

    private final String ID;

    private final String name;

    private String message;

    public Notification() {
        this.ID = "-1";
        this.name = "Notification";
    }

    public Notification(String name, String message) {

        if (null == name) {
            throw new NullPointerException("Name is null");
        }

        this.name = name;
        this.message = message;
        this.ID = Ultis.generatID(name);
    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String getText() {
        return this.message;
    }

}
