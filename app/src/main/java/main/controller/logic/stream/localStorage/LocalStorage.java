package main.controller.logic.stream.localStorage;

import android.content.Context;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import main.modell.storage.Storage;
import main.modell.storage.StorageAsSingelton;

public class LocalStorage implements ILocalStorage {

    private final static String PROJECT = "com.example.bluetoothmessenger";
    private final static String FILENAME = "lastSave.txt";

    private Storage storage;
    private Set<String> pathSet;
    private Set<String> fileNames;
    private byte[] data = null;

    public LocalStorage() {
        this.storage = StorageAsSingelton.getIntance();
    }

    /**
     * Get Storage as byte[]
     *
     * @return if not exception return data[] else null
     */
    private synchronized byte[] getBytes() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(this.storage);
            out.flush();
            byte[] temp = bos.toByteArray();
            data = temp;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return data;
    }

    @Override
    public synchronized boolean save(Context context) {

        byte[] data = getBytes();
        Log.e("Save", "byte[] length: " + data.length);

        //File path = new File("/Android/data/" + PROJECT + "/files/");
        File file = new File(context.getFilesDir(), FILENAME);

        Log.e("Save", context.getFilesDir().toString());
        Log.e("Save", file.getAbsolutePath());

        //Add to management env

        //This point and below is responsible for the write operation
        FileOutputStream outputStream = null;
        try {
            //file.mkdir();
            file.createNewFile();
            outputStream = new FileOutputStream(file);

            outputStream.write(data);
            outputStream.flush();
            outputStream.close();

            Log.e("Save", "File has been create");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Save " + IOException.class.getSimpleName(), e.getMessage());
            return false;
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                    Log.e("Save", "OutputStream close()");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("Save " + IOException.class.getSimpleName(), e.getMessage());
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public Set<String> getFileNames() {
        return this.fileNames;
    }

    @Override
    public Set<String> getPathList() {
        return this.pathSet;
    }

    @Override
    public Storage read(Context context) throws NullPointerException {

        Storage storage = null;
        String path = context.getFilesDir() + "/" + FILENAME;

        File file = context.getFileStreamPath(FILENAME);

        if (file.exists()) {

            Log.e("ReadStorage", "File exists");

            FileInputStream inputStream = null;
            ObjectInputStream objectInputStream = null;
            try {
                inputStream = new FileInputStream(path);
                objectInputStream = new ObjectInputStream(inputStream);

                storage = (Storage) objectInputStream.readObject();
                Log.e("ReadStorage", storage.toString());

                inputStream.close();
                objectInputStream.close();
                Log.e("ReadStorage", "File has been create");
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("ReadStorage " + IOException.class.getSimpleName(), e.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        Log.e("Save", "inputStream close()");
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.e("Save " + IOException.class.getSimpleName(), e.getMessage());
                    }
                }

                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                        Log.e("Save", "objectInputStream close()");
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.e("Save " + IOException.class.getSimpleName(), e.getMessage());
                    }
                }
            }
        } else {
            throw new NullPointerException("File not found");
        }

        return storage;
    }

    @Override
    public synchronized boolean addToStorage(Storage storage) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public byte[] getData() {
        return this.data;
    }
}
