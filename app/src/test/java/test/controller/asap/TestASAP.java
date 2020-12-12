package test.controller.asap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.sharksystem.asap.ASAPException;
import net.sharksystem.asap.ASAPMessages;
import net.sharksystem.asap.ASAPStorage;
import net.sharksystem.asap.apps.ASAPMessageReceivedListener;
import net.sharksystem.asap.apps.ASAPMessageSender;
import net.sharksystem.asap.apps.mock.ASAPSessionMock;

import org.junit.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import test.controller.asap.mock.ASAPMockSerial;

public class TestASAP {

    @Test
    public void sendMesssage() throws IOException, ASAPException, InterruptedException {

        byte[] serialData = ASAPMockSerial.serialize("Ein Weltwunder ein Weltwunder");

        ASAPSessionMock asapSessionMock = new ASAPSessionMock();

        ASAPMessageSender asapMessageSender = asapSessionMock;

        //TODO Erstellen
        asapMessageSender.sendASAPMessage(ASAPMockSerial.APP, ASAPMockSerial.URI, serialData);

        //TODO Erstellen Listener
        ASAPMessageReceivedListener asapMessageReceivedListener = new ASAPMessageReceivedListener() {
            @Override
            public void asapMessagesReceived(ASAPMessages asapMessages) throws IOException {
                CharSequence format = asapMessages.getFormat();
                CharSequence uri = asapMessages.getURI();

                System.out.println("FORMAT  : " + format + " URI: " + uri + " SIZE " + asapMessages.size());
                Iterator<byte[]> iterator = asapMessages.getMessages();

                while (iterator.hasNext()) {
                    ASAPMockSerial.deserialize(iterator.next());
                }
            }
        };

        //TODO in ASAP Application
        asapSessionMock.addASAPMessageReceivedListener(ASAPMockSerial.APP, asapMessageReceivedListener);

        asapSessionMock.connect();

        Thread.sleep(1000);

        asapMessageSender.sendASAPMessage(ASAPMockSerial.APP, ASAPMockSerial.URI, ASAPMockSerial.serialize("ICH SENDE ALS 1"));

        asapMessageSender.sendASAPMessage(ASAPMockSerial.APP, ASAPMockSerial.URI, ASAPMockSerial.serialize("ICH SENDE ALS 2 das ist ja krass"));

        asapSessionMock.disconnect();
        Thread.sleep(1000);

        asapMessageSender.sendASAPMessage(ASAPMockSerial.APP, ASAPMockSerial.URI, ASAPMockSerial.serialize("ICH SENDE ALS 3 das ist ja krass um mein GOD"));

        asapSessionMock.connect();
        Thread.sleep(1000);

        asapMessageSender.sendASAPMessage(ASAPMockSerial.APP, ASAPMockSerial.URI, ASAPMockSerial.serialize("ICH SENDE ALS 4 das ist ja krass wie heftig"));


    }

}

