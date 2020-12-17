package main3.controller.logic.CRUD;

import main3.modell.data.IChannel;
import main3.modell.data.IUser;
import main3.modell.storage.Storage;
import main3.modell.storage.StorageAsSingelton;

public class Delete implements IDelete {

    private Storage storage;

    public Delete() {
        this.storage = StorageAsSingelton.getIntance();
    }

    @Override
    public boolean deleteChannel(IChannel iChannel) {
        this.storage.removeChannel(iChannel.getID());
        return false;
    }

    @Override
    public boolean deleteUser(IUser iUser) {
        this.storage.removeUser(iUser.getID());
        return false;
    }
}
