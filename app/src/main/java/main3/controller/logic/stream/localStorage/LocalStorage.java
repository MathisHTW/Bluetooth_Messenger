package main3.controller.logic.stream.localStorage;

import android.content.Context;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import main3.modell.storage.Storage;
import main3.modell.storage.StorageAsSingelton;

public class LocalStorage implements ILocalStorage {

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

        String filename = this.hashCode() + "-" + new Date() + ".txt";
        File path = context.getFilesDir();
        File file = new File(path, filename);

        Log.e("Save", path.toString());
        Log.e("Save", file.getAbsolutePath());

        //Add to management env
        //this.pathSet.add(file.getAbsolutePath());
        //this.fileNames.add(filename);

        //This point and below is responsible for the write operation
        FileOutputStream outputStream = null;
        try {
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

    private String getLastFileSave() throws NullPointerException {

        if (this.getPathList().isEmpty()) {
            throw new NullPointerException("Path list is empty");
        }

        Iterator<String> iterator = this.getPathList().iterator();

        int index = 0;

        String getTemp = null;

        while (iterator.hasNext()) {

            String temp = null;

            if ((this.getPathList().size() - 1) == index) {
                getTemp = temp;
            }

            temp = iterator.next();
            index++;
        }

        return getTemp;
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
    public Storage getFile() {

        String path = this.getLastFileSave();

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);


            Log.e("Save", "File has been create");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Save " + IOException.class.getSimpleName(), e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                    Log.e("Save", "OutputStream close()");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("Save " + IOException.class.getSimpleName(), e.getMessage());
                }
            }
        }

        return null;
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
