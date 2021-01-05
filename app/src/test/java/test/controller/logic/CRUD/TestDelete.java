package test.controller.logic.CRUD;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.controller.logic.CRUD.Create;
import main.controller.logic.CRUD.Delete;
import main.modell.storage.Storage;

public class TestDelete {

    @Before
    public void setup() {
        Create create = new Create();
        create.createUser("Jim Knopf");
        create.createChannel("GTA V");
    }

    @Test
    public void deleteAllWithOneUserAndOneChannel() {
        Delete delete = new Delete();
        delete.deleteAll();
        Assert.assertEquals(1, Storage.getInstance().getChannelList().size());
        Assert.assertEquals(Storage.DEFAULT_APP_USERNAME, Storage.getInstance().getAppOwnerName().getName());
    }

    @Test
    public void deleteAllWithMoreUserAndChannel() {
        Create create = new Create();
        create.createUser("Paule");
        create.createChannel("Mordhau");
        create.createUser("Richard");
        create.createChannel("Transport fiver");
        create.createUser("Torsten Pimmel");
        create.createChannel("Mathe 1");
        create.createUser("Biene");
        create.createChannel("GTA IV");

        Delete delete = new Delete();
        delete.deleteAll();
        Assert.assertEquals(1, Storage.getInstance().getChannelList().size());
        Assert.assertEquals(Storage.DEFAULT_APP_USERNAME, Storage.getInstance().getAppOwnerName().getName());
    }

    @Test
    public void deleteChannel() {
        Storage.getInstance().clear();
        Create create = new Create();
        create.createChannel("PowerTower");

        Delete delete = new Delete();
        delete.deleteChannel("PowerTower");

        Assert.assertEquals(1, Storage.getInstance().getChannelList().size());
    }

}
