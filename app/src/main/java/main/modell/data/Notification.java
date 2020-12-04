package main.modell.data;

public class Notification implements INotification{

    private int ID;

    private String name;

    public Notification(int ID, String name){
        this.ID = ID;
        this.name = name;
    }

    public int getID(){
        return this.ID;
    }

    public String getName(){
        return this.name;
    }

}
