package main.Logic;

import java.util.List;

public interface Logic {

    //inteface to GUI
    /**
     * enables Bluetooth and informs all connected devices about the new participant by broadcasting the name
     * and other relevant information, like an unique identifier to enable future communication
     * @param name of this device, visible for all connected devices
     * @return true when Bluetooth is enabled and the name was sent to all connected Devices
     */
    boolean join(String name);

    /**
     * used by GUI to refresh the available contacts
     * @return the list of names of the currently connected devices
     */
    List<String> listContacts();

    /**
     * sends the given message to the known and available contact
     * @param contact unique identifier of the message receiver
     * @param message that is to be sent
     * @return true if the message was successfully delivered, false if there is a time out
     */
    boolean sendMessage(macaddress contact, String message);

    /**
     * delivers all the SUCCESSFULLY sent and received messages of the given contact
     * @param contact whose messages shall be shown
     * @return all the sent and received messages of the given contact
     */
    List<String> listMessages(macaddress contact);

    //inteface to network

    /**
     * if a new Contact makes himself visible to this device(using iAmNewHere), this Method will add this Contact to the List of known contacts
     * @param name of the newly visible contact
     * @param contact unique identifier of the newly visible contact
     * @return true if the new contact was successfully added to the list, false otherwise
     */
    boolean addContact(String name,macadress contact);
    //warum in Logic und nicht in model direkt?
    //was wenn Kontakt schon bekannt? -> muss nicht nochmal geaddet werden -> Logic lehnt ab

    /**
     * this device receives a message from an available contact and saves it in the list of
     * sent and received messages of this contact
     * @param contact the device that sent this message
     * @param message
     * @return true if the received message was successfully saved, false otherwise
     */
    boolean receiveMessage(macaddress contact, String message);

}
