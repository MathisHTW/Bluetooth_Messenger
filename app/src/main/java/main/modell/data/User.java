package main.modell.data;

public class User implements IUser {

    private String name;
    private String id;

    public User() {
        this.id = "-1";
        this.name = "Dummy";
    }

    public User(String name, String id) {
        this.name = name;
        this.id = id;
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
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
