package main3.controller.logic.CRUD;

import main3.modell.storage.Storage;
import main3.modell.storage.StorageAsSingelton;

public class Read {

    private Storage storage;

    public Read() {
        this.storage = StorageAsSingelton.getIntance();
    }


}
