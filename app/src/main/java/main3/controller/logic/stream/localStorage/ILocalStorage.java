package main3.controller.logic.stream.localStorage;

import android.content.Context;

import java.util.Set;

import main3.modell.storage.Storage;

interface ILocalStorage {

    /**
     * Save a from current storage in to localStorage
     *
     * @return create a file with HashCode name at Docuements/BluetoothMessenger/FILE.ser
     */
    boolean save(Context context);

    /**
     * Get a List of current saved Storages
     *
     * @return Set of path
     */
    Set<String> getPathList();

    /**
     * Select a file out of path
     *
     * @return return storage element from file
     */
    Storage getFile();

    /**
     * Get a Storage elements and add to Storage
     *
     * @param storage = not null
     * @return if true added to storage | false something is wrong
     */
    boolean addToStorage(Storage storage);

    /**
     * Clear a current directory
     *
     * @return if true all clear up | false something is wrong
     */
    boolean deleteAll();

    /**
     * Return from save methode a data byte array
     * @return byte[]
     */
    byte[] getData();

    /**
     * Return names of files
     * @return Set
     */
    Set<String> getFileNames();
}
