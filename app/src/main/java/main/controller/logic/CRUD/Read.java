package main.controller.logic.CRUD;

import main.modell.data.IUser;
import main.modell.storage.Storage;
import main.modell.storage.StorageAsSingelton;

public class Read {

    private Storage storage;

    public Read() {
        this.storage = StorageAsSingelton.getIntance();
    }


}
