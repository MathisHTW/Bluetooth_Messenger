package main.modell.data;

import java.util.List;

public interface IChannel {

    String getID();

    String getName();

    List<IUser> getUserList();

}
