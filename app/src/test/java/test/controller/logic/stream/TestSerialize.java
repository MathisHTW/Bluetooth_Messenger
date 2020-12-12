package test.controller.logic.stream;

import org.junit.Assert;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.IOException;

import main.controller.logic.stream.Serialize;
import main.modell.data.IUser;
import main.modell.data.User;

public class TestSerialize {

    private static final String iUserName = "Kevin";
    private static final String iUserID = "123";
    private static final String iUser1Name = "Matis";
    private static final String iUser1ID = "3242";

    private static final IUser iUser = new User(iUserName, iUserID);
    private static final IUser iUser1 = new User(iUser1Name, iUser1ID);

    @Test
    public void serializeAndDeserialize() throws IOException {

        String msg = "Ich Sende jetzt los alter";
        String msg1 = "Ich sende jetzt zurück alter";

        Serialize serialize = new Serialize();
        byte[] one = serialize.serializer(iUser, msg);
        byte[] two = serialize.serializer(iUser1, msg1);
        DataInputStream data = serialize.deserializer(one);
        DataInputStream data1 = serialize.deserializer(two);

        Assert.assertEquals(iUserName, data.readUTF());
        Assert.assertEquals(iUserID, data.readUTF());
        Assert.assertEquals(msg, data.readUTF());

        Assert.assertEquals(iUser1Name, data1.readUTF());
        Assert.assertEquals(iUser1ID, data1.readUTF());
        Assert.assertEquals(msg1, data1.readUTF());
    }

}
