package test.controller.logic.stream;

import org.junit.Assert;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.IOException;

import main.controller.logic.stream.SerializableMessages;
import main.controller.logic.stream.SerializeMessages;
import main.modell.data.IUser;
import main.modell.data.User;

public class TestSerializeMessages {

    private static final String iUserName = "Kevin";
    private static final String iUser1Name = "Matis";

    private static final IUser iUser = new User(iUserName);
    private static final IUser iUser1 = new User(iUser1Name);

    @Test
    public void serializeAndDeserialize() throws IOException {
        String msg = "Ich Sende jetzt los alter";
        String msg1 = "Ich sende jetzt zurück alter";

        SerializeMessages serializeMessages = new SerializeMessages();
        byte[] one = serializeMessages.serializer(iUser, msg);
        byte[] two = serializeMessages.serializer(iUser1, msg1);
        DataInputStream data = serializeMessages.deserializer(one);
        DataInputStream data1 = serializeMessages.deserializer(two);

        Assert.assertEquals(iUserName, data.readUTF());
        Assert.assertEquals(msg, data.readUTF());

        Assert.assertEquals(iUser1Name, data1.readUTF());
        Assert.assertEquals(msg1, data1.readUTF());
    }

    @Test
    public void serializeSetNull() {
        SerializableMessages serializableMessages = new SerializeMessages();

        try {
            byte[] one = serializableMessages.serializer(null, null);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void deserializeSetNull() {
        SerializableMessages serializableMessages = new SerializeMessages();

        try {
            serializableMessages.deserializer(null);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        }
    }

}
