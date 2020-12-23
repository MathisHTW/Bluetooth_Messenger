package main.modell.storage;

import java.io.Serializable;

public final class StorageAsSingelton implements Serializable {

    private StorageAsSingelton() {
    }

    private volatile static Storage instance;

    /**
     * Get Storage Func
     * @return Storage instance
     */
    public synchronized static Storage getIntance() {
        if (null == instance) {
            instance = new Storage();
        }
        return instance;
    }

}
