package main.modell.data;

import java.io.Serializable;

public class Message extends Notification implements Serializable {

    public Message(String name, String text) {
        super(name, text);
    }
}
