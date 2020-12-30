package main.controller.logic.stream;

import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import main.modell.data.IUser;

public class SerializeMessages implements SerializableMessages {

    @Override
    public byte[] serializer(IUser iUser, String msg) throws NullPointerException {

        if (null == iUser || msg == null) {
            Log.e("Debug", "User or Msg is null");
            throw new NullPointerException("User or Msg is null");
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        try {
            dataOutputStream.writeUTF(iUser.getName());
            dataOutputStream.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public DataInputStream deserializer(byte[] data) {

        if (null == data || data.length == 0) {
            throw new NullPointerException("data is null or data.length = 0");
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        return dataInputStream;
    }
}
