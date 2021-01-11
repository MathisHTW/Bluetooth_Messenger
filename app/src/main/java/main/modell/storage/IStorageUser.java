package main.modell.storage;

import java.util.List;

import main.modell.data.IUser;

interface IStorageUser {
    IUser getAppOwnerName();

    /**
     * sets the Name of the User
     *
     * @param appOwnerName
     */
    void setAppOwnerName(IUser appOwnerName);

    /**
     *  adds a User
     *
     * @param iUser
     */
    void addUser(IUser iUser);

    /**
     * adds a List of Users
     *
     * @param iUsers
     */
    void addAllUser(List<IUser> iUsers);

    /**
     * removes a User
     *
     * @param id
     */
    void removeUser(String id);

    /**
     * returns a List of Users
     *
     * @return
     */
    List<IUser> getUserList();
}
