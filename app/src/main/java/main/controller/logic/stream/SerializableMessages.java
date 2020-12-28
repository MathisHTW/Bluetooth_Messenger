package main.controller.logic.stream;

import java.io.DataInputStream;

import main.modell.data.IUser;

public interface SerializableMessages {

    /**
     * Serialize input from Bluetooth messenger
     * @param iUser = user object (new User("id", "Name))
     * @param msg = sendable msg
     * @return
     */
    byte[] serializer(IUser iUser, String msg);

    /**
     * Deserialize input from Bluetooth messenger
     * @param data = byte[]
     * @return DataInputStream get deserialized dataStream
     */
    DataInputStream deserializer(byte[] data);

}
