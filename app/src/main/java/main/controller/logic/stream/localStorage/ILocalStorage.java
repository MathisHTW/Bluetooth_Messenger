package main.controller.logic.stream.localStorage;

import android.content.Context;

import java.util.Set;

import main.modell.storage.Storage;

interface ILocalStorage {

    /**
     * Save a from current storage in to localStorage
     *
     * @return if true =  create a file | false e.g exception
     */
    boolean save(Context context);

    /**
     * Select a file out of path
     *
     * @return return storage element from file
     */
    Storage read(Context context) throws NullPointerException;
}
