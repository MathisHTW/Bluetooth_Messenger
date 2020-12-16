package test.modell.data;

import org.junit.Assert;
import org.junit.Test;

import main.controller.logic.CRUD.Create;
import main.controller.logic.CRUD.Delete;
import main.modell.storage.Storage;
import main.modell.storage.StorageAsSingelton;

public class TestStorage {

    private Storage storage = StorageAsSingelton.getIntance();

    @Test
    public void createUser() {
        this.storage.clear();

        String name = "Paul Panzer";

        Create create = new Create();
        create.createUser(name);

        Assert.assertEquals(name, this.storage.getUserList().get(0).getName());
    }

    @Test
    public void createUserWithoutName() {
        this.storage.clear();

        String name = "";

        Create create = new Create();

        try {
            create.createUser(name);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void deleteUser() {
        this.storage.clear();

        String name = "Peter Zwegert";

        Create create = new Create();
        create.createUser(name);

        Delete delete = new Delete();
        delete.deleteUser(this.storage.getUserList().get(0));

        Assert.assertEquals(0, this.storage.getUserList().size());
    }

    @Test
    public void DeleteUserWithEmtpyParameter() {
        this.storage.clear();

    }

    @Test
    public void addToStorage() {
        this.storage.clear();

        String name = "Peter Zwegert";
        String name1 = "Kevin Zwegert";
        String name2 = "JONAS Zwegert";
        String name3 = "Achime Zwegert";

        Create create = new Create();
        create.createUser(name);
        create.createUser(name1);
        create.createUser(name2);
        create.createUser(name3);

        Assert.assertEquals(4, this.storage.getUserList().size());
    }
}
