package main.controller.logic.CRUD;

import main.controller.logic.stream.localStorage.LocalStorage;
import main.modell.storage.Storage;
import main.modell.storage.StorageAsSingelton;

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
