package main.controller.logic.CRUD;

import java.util.List;

import main.modell.data.IUser;

interface ICreate {

    /**
     * Create a Channel and add this to Storage
     *
     * @param name
     */
    boolean createChannel(String name, List<IUser> users);

    /**
     * Create a User and add this to storage
     *
     * @param name
     */
    boolean createUser(String name);


}
