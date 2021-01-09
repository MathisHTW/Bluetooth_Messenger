package test.controller.logic.CRUD;

import org.junit.Assert;
import org.junit.Test;

import main.controller.logic.CRUD.Create;
import main.controller.logic.CRUD.Read;
import main.modell.storage.Storage;

public class TestRead {

    @Test
    public void defaultSizeOfChannelIsOne() {
        final Read read = new Read();
        Assert.assertEquals(1, read.getChannels().size());
    }

    @Test
    public void getChannels(){
        Storage.getInstance().clear();
        Create create = new Create();
        create.createChannel("Power");
        create.createChannel("Power2");

        Read read = new Read();
        Assert.assertEquals("Power",read.getChannels().get(1).getName());   //first ChannelName = Public
        Assert.assertEquals("Power2",read.getChannels().get(2).getName());
    }

    @Test
    public void getAppOwner(){
        Storage.getInstance().clear();
        Create create = new Create();
        create.createUser("AppOwner");

        Read read = new Read();
        Assert.assertEquals("AppOwner",read.getAppOwner().getName());
    }



}
