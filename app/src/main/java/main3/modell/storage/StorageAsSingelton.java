package main3.modell.storage;

import java.io.Serializable;

public final class StorageAsSingelton implements Serializable {

    private StorageAsSingelton() {
    }

    private volatile static Storage intance;

    public synchronized static Storage getIntance() {
        if (null == intance) {
            intance = new Storage();
        }
        return intance;
    }

}
