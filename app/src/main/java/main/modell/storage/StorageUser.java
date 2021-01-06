package main.modell.storage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import main.modell.data.IUser;

class StorageUser implements IStorageUser, Serializable {

    private IUser appOwnerName;
    private List<IUser> userList;

    public StorageUser(List<IUser> userList) {
        this.userList = userList;
    }

    @Override
    public IUser getAppOwnerName() {
        return this.appOwnerName;
    }

    @Override
    public void setAppOwnerName(IUser appOwnerName) {
        this.appOwnerName = appOwnerName;
    }

    @Override
    public void addUser(IUser iUser) {
        this.userList.add(iUser);
    }

    @Override
    public void addAllUser(List<IUser> iUsers) {
        this.userList.addAll(iUsers);
    }

    @Override
    public void removeUser(String id) {
        IUser removeUser = null;

        for (IUser iUser : this.userList) {
            if (iUser.getID().compareTo(id) == 0) {
                removeUser = iUser;
            }
        }

        this.userList.remove(removeUser);
    }

    @Override
    public List<IUser> getUserList() {
        return this.userList;
    }

    @Override
    public String toString() {
        return "StorageUser{" +
                "appOwnerName=" + appOwnerName +
                ", userList=" + Arrays.toString(userList.toArray()) +
                '}';
    }
}
