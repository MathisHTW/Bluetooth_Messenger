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

    @Test
    public void deleteSingleMessage(){
        Storage.getInstance().clear();
        Create create = new Create();
        create.createMessage("SenderName","Nachricht 1 2 4");
        Assert.assertEquals("SenderName",Storage.getInstance().getNotificationList().get(0).getName());
        Assert.assertEquals("Nachricht 1 2 4",Storage.getInstance().getNotificationList().get(0).getText());

        Delete delete = new Delete();
        delete.deleteMessage(Storage.getInstance().getNotificationList().get(0));
        Assert.assertNull(Storage.getInstance().getNotificationList().get(0));
    }

    @Test
    public void deleteSingleMessageOutOfTwoBySameSender(){
        Storage.getInstance().clear();
        Create create = new Create();
        create.createMessage("SenderName","Nachricht 1 2 4");
        create.createMessage("SenderName","Nachricht Neu 3");
        Assert.assertEquals("SenderName",Storage.getInstance().getNotificationList().get(0).getName());
        Assert.assertEquals("Nachricht 1 2 4",Storage.getInstance().getNotificationList().get(0).getText());
        Assert.assertEquals("SenderName",Storage.getInstance().getNotificationList().get(1).getName());
        Assert.assertEquals("Nachricht Neu 3",Storage.getInstance().getNotificationList().get(1).getText());

        Delete delete = new Delete();
        delete.deleteMessage(Storage.getInstance().getNotificationList().get(0));
        Assert.assertNull(Storage.getInstance().getNotificationList().get(0));
        //Was passiert ? rückt die Nachricht auf? oder bleibt sie an ihrem ursprünglichen Ort index=1 ?
        Assert.assertEquals("SenderName",Storage.getInstance().getNotificationList().get(1).getName());
        Assert.assertEquals("Nachricht Neu 3",Storage.getInstance().getNotificationList().get(1).getText());
    }

    @Test
    public void deleteSingelMessageOutOfTwoByDifferentSender(){
        Storage.getInstance().clear();
        Create create = new Create();
        create.createMessage("SenderName1","Nachricht 1 2 4");
        create.createMessage("SenderName2","Nachricht Neu 3");
        Assert.assertEquals("SenderName1",Storage.getInstance().getNotificationList().get(0).getName());
        Assert.assertEquals("Nachricht 1 2 4",Storage.getInstance().getNotificationList().get(0).getText());
        Assert.assertEquals("SenderName2",Storage.getInstance().getNotificationList().get(1).getName());
        Assert.assertEquals("Nachricht Neu 3",Storage.getInstance().getNotificationList().get(1).getText());

        Delete delete = new Delete();
        delete.deleteMessage(Storage.getInstance().getNotificationList().get(0));
        Assert.assertNull(Storage.getInstance().getNotificationList().get(0));
        //Was passiert ? rückt die Nachricht auf? oder bleibt sie an ihrem ursprünglichen Ort index=1 ?
        Assert.assertEquals("SenderName2",Storage.getInstance().getNotificationList().get(1).getName());
        Assert.assertEquals("Nachricht Neu 3",Storage.getInstance().getNotificationList().get(1).getText());
    }

    @Test
    public void deleteSingleSimilarMessageOutOfTwoByDifferentSender(){
        Storage.getInstance().clear();
        Create create = new Create();
        create.createMessage("SenderName1","Gleiche Nachricht");
        create.createMessage("SenderName2","Gleiche Nachricht");
        Assert.assertEquals("SenderName1",Storage.getInstance().getNotificationList().get(0).getName());
        Assert.assertEquals("Gleiche Nachricht",Storage.getInstance().getNotificationList().get(0).getText());
        Assert.assertEquals("SenderName2",Storage.getInstance().getNotificationList().get(1).getName());
        Assert.assertEquals("Gleiche Nachricht",Storage.getInstance().getNotificationList().get(1).getText());

        Delete delete = new Delete();
        delete.deleteMessage(Storage.getInstance().getNotificationList().get(0));
        Assert.assertNull(Storage.getInstance().getNotificationList().get(0));
        //Was passiert ? rückt die Nachricht auf? oder bleibt sie an ihrem ursprünglichen Ort index=1 ?
        Assert.assertEquals("SenderName2",Storage.getInstance().getNotificationList().get(1).getName());
        Assert.assertEquals("Gleiche Nachricht",Storage.getInstance().getNotificationList().get(1).getText());
    }

    @Test
    public void deleteSeveralMessages(){
        Storage.getInstance().clear();
        Create create = new Create();
        create.createMessage("Sender1","Nachricht 1");
        create.createMessage("Sender1","Nachricht 2");
        create.createMessage("Sender2","Nachricht 3");
        create.createMessage("Sender4","Nachricht 4");
        Assert.assertEquals("Sender1",Storage.getInstance().getNotificationList().get(0).getName());
        Assert.assertEquals("Nachricht 1",Storage.getInstance().getNotificationList().get(0).getText());
        Assert.assertEquals("Sender1",Storage.getInstance().getNotificationList().get(1).getName());
        Assert.assertEquals("Nachricht 2",Storage.getInstance().getNotificationList().get(1).getText());
        Assert.assertEquals("Sender2",Storage.getInstance().getNotificationList().get(2).getName());
        Assert.assertEquals("Nachricht 3",Storage.getInstance().getNotificationList().get(2).getText());
        Assert.assertEquals("Sender4",Storage.getInstance().getNotificationList().get(3).getName());
        Assert.assertEquals("Nachricht 4",Storage.getInstance().getNotificationList().get(3).getText());

        Delete delete = new Delete();
        delete.deleteMessage(Storage.getInstance().getNotificationList().get(0));
        delete.deleteMessage(Storage.getInstance().getNotificationList().get(1));
        delete.deleteMessage(Storage.getInstance().getNotificationList().get(2));
        delete.deleteMessage(Storage.getInstance().getNotificationList().get(3));

        //Nicht Sicher ob das hier so funktioniert:
        Assert.assertEquals(1, Storage.getInstance().getNotificationList().size());
    }

}
