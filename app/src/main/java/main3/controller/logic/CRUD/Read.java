package main3.controller.logic.CRUD;

import main3.controller.logic.stream.localStorage.LocalStorage;
import main3.modell.storage.Storage;
import main3.modell.storage.StorageAsSingelton;

public class Read {

    private Storage storage;

    public Read() {
        this.storage = StorageAsSingelton.getIntance();
    }

    public boolean readStorage() {
        LocalStorage localStorage = new LocalStorage();
        return localStorage.addToStorage(this.storage);
    }
}
