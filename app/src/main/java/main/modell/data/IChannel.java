package main.modell.data;

import java.util.List;

public interface IChannel {

    String getID();

    String name();

    List<IUser> getUserList();

}
