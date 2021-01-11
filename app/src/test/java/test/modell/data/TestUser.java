package test.modell.data;

import org.junit.Assert;
import org.junit.Test;

import main.modell.data.IUser;
import main.modell.data.User;

public class TestUser {

    @Test
    public void createUserCheckID() {
        IUser iUser = new User("Kevin");
        Assert.assertFalse(iUser.getID().equals("-1"));
    }

    @Test
    public void createUserToStringReturnOnlyName() {
        IUser iUser = new User();
        Assert.assertEquals(iUser.getName(), iUser.toString());
    }

    @Test
    public void createUserNameIsNull() {
        try {
            IUser iUser = new User(null);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        }

    }
}
