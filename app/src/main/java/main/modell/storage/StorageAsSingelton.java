package main.modell.storage;

public final class StorageAsSingelton {

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
