package main.controller.logic.CRUD;

import main.modell.storage.Storage;

public class Read {

    private Storage storage;

    public Read() {
        this.storage = Storage.getIntance();
    }

}
