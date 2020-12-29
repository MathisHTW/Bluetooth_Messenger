package test.controller.logic.stream.localStorage;

import android.app.Instrumentation;

import org.junit.Assert;
import org.junit.Test;

import main.controller.logic.stream.localStorage.LocalStorage;

public class TestLocalStorage {

    @Test
    public void saveContextIsNull() {
        LocalStorage localStorage = new LocalStorage();

        try {
            localStorage.save(null);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.fail();
        }

    }

    @Test
    public void readContextIsNull() {
        LocalStorage localStorage = new LocalStorage();

        try {
            localStorage.read(null);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.fail();
        }
    }

}
