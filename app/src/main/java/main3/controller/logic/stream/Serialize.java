package main3.controller.logic.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import main3.modell.data.IUser;

public class Serialize implements Serializable {

    @Override
    public byte[] serializer(IUser iUser, String msg) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        try {
            dataOutputStream.writeUTF(iUser.getName());
            dataOutputStream.writeUTF(iUser.getID());
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
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        return dataInputStream;
    }
}
