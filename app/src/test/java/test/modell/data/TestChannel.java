package test.modell.data;

import org.junit.Assert;
import org.junit.Test;

import main.modell.data.Channel;
import main.modell.data.IChannel;
import main.modell.storage.Storage;

public class TestChannel {

    @Test
    public void createChannel() {
        Storage.getInstance().clear();
        IChannel channel = new Channel("Name");
        Assert.assertEquals(1, Storage.getInstance().getChannelList().size());
    }

    @Test
    public void createChannelIsNull() {
        try {
            IChannel channel = new Channel(null);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        }
    }

}
