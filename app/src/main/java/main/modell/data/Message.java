package main.modell.data;

import java.io.Serializable;

public class Message extends Notification implements Serializable {
    private String text;

    public String getText() {
        return this.text;
    }

    public Message(String name, String text) {
        super(name);
        this.text = text;
    }
}
