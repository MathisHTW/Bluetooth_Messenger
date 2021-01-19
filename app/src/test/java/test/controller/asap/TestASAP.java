package test.controller.asap;

import net.sharksystem.asap.ASAPException;
import net.sharksystem.asap.ASAPMessages;
import net.sharksystem.asap.apps.ASAPMessageReceivedListener;
import net.sharksystem.asap.apps.ASAPMessageSender;
import net.sharksystem.asap.apps.mock.ASAPSessionMock;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Iterator;

import main.controller.logic.stream.SerializableMessages;
import main.controller.logic.stream.SerializeMessages;
import main.modell.data.User;
import test.controller.asap.mock.ASAPMockSerial;

public class TestASAP {

    @Test
    public void sendMessage() throws ASAPException, InterruptedException {

        final SerializableMessages serializableMessages = new SerializeMessages();
        final byte[] serialData = serializableMessages.serializer(new User("Kevin"), "HALLO ich bin ready");

        //TODO
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
                    DataInputStream stream = serializableMessages.deserializer(iterator.next());
                    System.out.println(stream.readUTF());
                    System.out.println(stream.readUTF());
                }
            }
        };

        //TODO in ASAP impl Interface interface | Abruf bei der ASAP application
        asapSessionMock.addASAPMessageReceivedListener(ASAPMockSerial.APP, asapMessageReceivedListener);

        asapSessionMock.connect();

        Thread.sleep(1000);

        asapMessageSender.sendASAPMessage(ASAPMockSerial.APP, ASAPMockSerial.URI, serializableMessages.serializer(new User("Tom"), "Tom  jo alter das geht"));

        asapMessageSender.sendASAPMessage(ASAPMockSerial.APP, ASAPMockSerial.URI, serializableMessages.serializer(new User("Matis"), "Ich lade die App gleich runter"));

        asapSessionMock.disconnect();
        Thread.sleep(1000);

        asapMessageSender.sendASAPMessage(ASAPMockSerial.APP, ASAPMockSerial.URI, serializableMessages.serializer(new User("God"), "Ich habe eh alles geschaffen du Noob gg ez"));

        asapSessionMock.connect();
        Thread.sleep(1000);

        asapMessageSender.sendASAPMessage(ASAPMockSerial.APP, ASAPMockSerial.URI, serializableMessages.serializer(new User("AntiMade"), "Rush b cyra blat"));
    }
}

