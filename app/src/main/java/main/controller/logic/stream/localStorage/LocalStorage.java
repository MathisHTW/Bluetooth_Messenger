package main.controller.logic.stream.localStorage;

import android.content.Context;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import main.modell.storage.Storage;

public class LocalStorage implements ILocalStorage {

    private final static String FILENAME = "lastSave.txt";

    private Storage storage;

    public LocalStorage() {
        this.storage = Storage.getInstance();
    }

    /**
     * Get Storage as byte[]
     *
     * @return if not exception return data[] else null
     */
    private byte[] getBytes() {
        byte[] data = null;
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

        if (null == context) {
            String msg = "Application Context is null";
            Log.e("NullPointerException", msg);
            throw new NullPointerException(msg);
        }

        byte[] data = getBytes();
        Log.d("LocalStorage", "byte[] length: " + data.length);

        //File path = new File("/Android/data/" + PROJECT + "/files/");
        File file = new File(context.getFilesDir(), FILENAME);

        Log.d("LocalStorage", context.getFilesDir().toString());
        Log.d("LocalStorage", file.getAbsolutePath());

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

            Log.d("LocalStorage", "File has been create");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Save " + IOException.class.getSimpleName(), e.getMessage());
            return false;
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                    Log.d("LocalStorage", "OutputStream close()");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("LocalStorage " + IOException.class.getSimpleName(), e.getMessage());
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public Storage read(Context context) throws NullPointerException {

        if (null == context) {
            String msg = "Application Context is null";
            Log.e("NullPointerException", msg);
            throw new NullPointerException(msg);
        }

        Storage storage = null;
        String path = context.getFilesDir() + "/" + FILENAME;

        File file = context.getFileStreamPath(FILENAME);

        if (file.exists()) {

            Log.d("LocalStorage", "File exists");

            FileInputStream inputStream = null;
            ObjectInputStream objectInputStream = null;
            try {
                inputStream = new FileInputStream(path);
                objectInputStream = new ObjectInputStream(inputStream);

                storage = (Storage) objectInputStream.readObject();

                Log.d("LocalStorage", storage.toString());

                inputStream.close();
                objectInputStream.close();
                Log.d("LocalStorage", "File has been create");
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("LocalStorage " + IOException.class.getSimpleName(), e.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        Log.d("LocalStorage", "inputStream close()");
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.e("LocalStorage " + IOException.class.getSimpleName(), e.getMessage());
                    }
                }

                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                        Log.d("LocalStorage", "objectInputStream close()");
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.e("LocalStorage " + IOException.class.getSimpleName(), e.getMessage());
                    }
                }
            }
        } else {
            throw new NullPointerException("File not found");
        }

        return storage;
    }
}
