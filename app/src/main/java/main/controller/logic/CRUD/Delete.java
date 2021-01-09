package main.controller.logic.CRUD;

import main.modell.data.IChannel;
import main.modell.data.INotification;
import main.modell.data.IUser;
import main.modell.storage.Storage;

public class Delete implements IDelete {

    private Storage storage;

    public Delete() {
        this.storage = Storage.getInstance();
    }

    @Override
    public boolean deleteChannel(String name) {
        this.storage.removeChannel(name);
        return true;
    }

    @Override
    public boolean deleteUser(IUser iUser) {
        this.storage.removeUser(iUser.getID());
        return true;
    }

    @Override
    public boolean deleteMessage(INotification iNotification) {
        this.storage.removeNotification(iNotification.getID());
        return true;
    }

    @Override
    public void deleteAll() {
        this.storage.clear();
    }

}
