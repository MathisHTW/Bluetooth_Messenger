package main.modell.storage;

import java.util.List;

import main.modell.data.IUser;

interface IStorageUser {
    IUser getAppOwnerName();

    void setAppOwnerName(IUser appOwnerName);

    void addUser(IUser iUser);

    void addAllUser(List<IUser> iUsers);

    void removeUser(String id);

    List<IUser> getUserList();
}
