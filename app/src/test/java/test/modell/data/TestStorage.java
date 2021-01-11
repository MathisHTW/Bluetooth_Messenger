package test.modell.data;

import org.junit.Assert;
import org.junit.Test;

import main.controller.logic.CRUD.Create;
import main.controller.logic.CRUD.Delete;
import main.modell.storage.Storage;

public class TestStorage {

    @Test
    public void createUser() {
        Storage storage = Storage.getInstance();
        storage.clear();

        String name = "Paul Panzer";

        Create create = new Create();
        create.createToUserList(name);

        Assert.assertEquals(name, storage.getUserList().get(0).getName());
    }

    @Test
    public void createUserWithoutName() {
        Storage storage = Storage.getInstance();
        storage.clear();

        String name = "";

        Create create = new Create();

        try {
            create.createToUserList(name);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void deleteUser() {
        Storage storage = Storage.getInstance();
        storage.clear();

        String name = "Peter Zwegert";

        Create create = new Create();
        create.createToUserList(name);

        Delete delete = new Delete();
        delete.deleteUser(storage.getUserList().get(0));

        Assert.assertEquals(0, storage.getUserList().size());
    }

    @Test
    public void addToStorage() {
        Storage storage = Storage.getInstance();
        storage.clear();

        String name = "Peter Zwegert";
        String name1 = "Kevin Zwegert";
        String name2 = "JONAS Zwegert";
        String name3 = "Achime Zwegert";

        Create create = new Create();
        create.createToUserList(name);
        create.createToUserList(name1);
        create.createToUserList(name2);
        create.createToUserList(name3);

        Assert.assertEquals(4, storage.getUserList().size());
    }
}
