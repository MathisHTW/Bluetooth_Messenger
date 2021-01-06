package test.controller.logic.CRUD;

import org.junit.Assert;
import org.junit.Test;

import main.controller.logic.CRUD.Create;
import main.modell.storage.Storage;

public class TestCreate {

    @Test
    public void createChannel() {
        Storage.getInstance().clear();
        Create create = new Create();
        create.createChannel("Power");
        Assert.assertEquals("Power", Storage.getInstance().getChannelList().get(1).getName());
    }

    @Test
    public void createAppOwner() {
        Storage.getInstance().clear();
        Create create = new Create();
        create.createUser("Tim");
        Assert.assertEquals("Tim", Storage.getInstance().getAppOwnerName().getName());
    }

    @Test
    public void changeAppOwner() {
        Storage.getInstance().clear();
        Create create = new Create();
        create.createUser("Paul");
        create.createUser("Peter");

        Assert.assertEquals("Peter", Storage.getInstance().getAppOwnerName().getName());
    }

    @Test
    public void createChannelWithSameName() {
        Storage.getInstance().clear();
        Create create = new Create();
        try {
            create.createChannel("Meins");
            create.createChannel("Meins");
        } catch (IllegalStateException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void addSingleUser(){
        Storage.getInstance().clear();
        Create create = new Create();
        create.createToUserList("newUser");

        Assert.assertEquals("newUser",Storage.getInstance().getUserList().get(0).getName());
    }

    @Test
    public void addTwoDifferentUsers(){
        Storage.getInstance().clear();
        Create create = new Create();
        create.createToUserList("newUser1");
        create.createToUserList("newUser2");

        Assert.assertEquals("newUser1",Storage.getInstance().getUserList().get(0).getName());
        Assert.assertEquals("newUser2",Storage.getInstance().getUserList().get(1).getName());
        Assert.assertNotEquals(Storage.getInstance().getUserList().get(0).getID(),Storage.getInstance().getUserList().get(1).getID());
    }

    @Test
    public void addTwoSimilarUsers(){
        Storage.getInstance().clear();
        Create create = new Create();
        create.createToUserList("newUser1");
        create.createToUserList("newUser1");

        Assert.assertEquals("newUser1",Storage.getInstance().getUserList().get(0).getName());
        Assert.assertEquals("newUser1",Storage.getInstance().getUserList().get(1).getName());
        Assert.assertNotEquals(Storage.getInstance().getUserList().get(0).getID(),Storage.getInstance().getUserList().get(1).getID());
    }
    

}
