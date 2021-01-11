package test.modell.storage;

import org.junit.Assert;
import org.junit.Test;

import main.modell.storage.Storage;

public class TestStorage {

    @Test
    public void clear() {
        Storage.getInstance().clear();
        Assert.assertEquals(1, Storage.getInstance().getChannelList().size());
    }

    @Test
    public void clearOnlyOnePublicChannel() {
        Storage.getInstance().clear();
        Storage.getInstance().clear();
        Storage.getInstance().clear();
        Storage.getInstance().clear();
        Assert.assertEquals(1, Storage.getInstance().getChannelList().size());
    }

    @Test
    public void getStorage() {
        Storage.getInstance().clear();
        Storage.getInstance().getChannelList();
        Storage.getInstance().getChannelList();
        Storage.getInstance().getChannelList();
        Storage.getInstance().getChannelList();
        Assert.assertEquals(1, Storage.getInstance().getChannelList().size());
    }

    @Test
    public void getStorageDefault() {
        Storage.getInstance().clear();
        Assert.assertEquals(1, Storage.getInstance().getChannelList().size());
        Assert.assertEquals(0, Storage.getInstance().getUserList().size());
        Assert.assertEquals(0, Storage.getInstance().getNotificationList().size());
        Assert.assertEquals(Storage.DEFAULT_APP_USERNAME, Storage.getInstance().getAppOwnerName().getName());
    }
}
