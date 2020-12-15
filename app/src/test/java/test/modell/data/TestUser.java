package test.modell.data;

import org.junit.Assert;
import org.junit.Test;

import main.modell.data.IUser;
import main.modell.data.User;

public class TestUser {

    @Test
    public void createUser(){
        try {
            IUser iUser = new User("Kevin");
        }catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void createUserWithoutString(){
        try {
            IUser iUser = new User();
        }catch (Exception e){
            Assert.assertTrue(true);
        }
    }
}
