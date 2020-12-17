package main3.modell.data;

public class Message extends Notification {
    private String text;

    public String getText(){
        return this.text;
    }

    public Message(int ID, String name, String text){
        super(ID, name);
        this.text = text;
    }
}
