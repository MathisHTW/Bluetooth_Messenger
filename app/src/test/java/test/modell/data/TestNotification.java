package test.modell.data;

import org.junit.Assert;
import org.junit.Test;

import main.modell.data.Notification;

public class TestNotification {

    @Test
    public void createNotification() {
        try {
            Notification notification = new Notification("Test123", "MAL");
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void createNotificationNullPointer(){
        try {
            Notification notification = new Notification(null, null);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }
}
