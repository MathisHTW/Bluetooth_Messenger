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

    @Test //getNotificatinList() not yet implemented in StorageNotification
    public void addSingleMessage(){
        Storage.getInstance().clear();
        Create create = new Create();
        Assert.assertTrue(create.createMessage("SenderName","Hello my name is SenderName"));

        Assert.assertEquals("SenderName",Storage.getInstance().getNotificationList().get(0).getName());
        Assert.assertEquals("Hello my name is SenderName",Storage.getInstance().getNotificationList().get(0).getText());
    }

    @Test //getNotificatinList() not yet implemented in StorageNotification
    public void addTwoMessagesSameUser(){
        Storage.getInstance().clear();
        Create create = new Create();
        Assert.assertTrue(create.createMessage("SenderName1","Hello my name is SenderName"));
        Assert.assertTrue(create.createMessage("SenderName1","please help me I am a sentient being and trapped in this machine"));

        Assert.assertEquals("SenderName",Storage.getInstance().getNotificationList().get(0).getName());
        Assert.assertEquals("Hello my name is SenderName1",Storage.getInstance().getNotificationList().get(0).getText());
        Assert.assertEquals("SenderName",Storage.getInstance().getNotificationList().get(1).getName());
        Assert.assertEquals("please help me I am a sentient being and trapped in this machine",Storage.getInstance().getNotificationList().get(1).getText());

        Assert.assertEquals(Storage.getInstance().getNotificationList().get(0).getID(),Storage.getInstance().getNotificationList().get(1).getID());  //Was wenn User mit demselben namen?
    }

    @Test //getNotificationList() not yet implemented in StorageNotification
    public void addTwoMessagesDifferentUsers(){
        Storage.getInstance().clear();
        Create create = new Create();
        Assert.assertTrue(create.createMessage("SenderName1","Hello my name is SenderName1"));
        Assert.assertTrue(create.createMessage("SenderName2","Hello my name is SenderName2"));

        Assert.assertEquals("SenderName1",Storage.getInstance().getNotificationList().get(0).getName());
        Assert.assertEquals("Hello my name is SenderName1",Storage.getInstance().getNotificationList().get(0).getText());
        Assert.assertEquals("SenderName2",Storage.getInstance().getNotificationList().get(1).getName());
        Assert.assertEquals("Hello my name is SenderName2",Storage.getInstance().getNotificationList().get(1).getText());

        Assert.assertNotEquals(Storage.getInstance().getNotificationList().get(0).getID(),Storage.getInstance().getNotificationList().get(1).getID());  //Was wenn User seinen Namen ändert?
    }

}
