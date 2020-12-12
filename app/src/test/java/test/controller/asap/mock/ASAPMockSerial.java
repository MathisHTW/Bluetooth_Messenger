package test.controller.asap.mock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

public class ASAPMockSerial {

    public static final CharSequence APP = "app";
    public static final CharSequence URI = "yourSchema://a";

    public static byte[] serialize(String msg) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutput dataOutput = new DataOutputStream(byteArrayOutputStream);

        dataOutput.writeUTF(msg);

        return byteArrayOutputStream.toByteArray();
    }

    public static void deserialize(byte[] data) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

        String msg = dataInputStream.readUTF();

        System.out.println("Received: " + msg);
    }

}
