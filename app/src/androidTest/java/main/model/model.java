package main.model;

import java.util.List;

public interface model {

    //interface an Logic
    /**
     * used by Logic to deliver the AVAILABLE contacts to the GUI to refresh the view
     * @return the list of names of the currently connected devices
     */
    List<String> listOfContacts();

    /**
     * if a new Contact makes himself visible to this device, this Method will add this Contact to the List of known contacts
     * @param name of the newly visible contact
     * @param ID unique identifier of the newly visible contact
     * @return true if the new contact was successfully added to the list, false otherwise
     */
    boolean addContact(String name,macaddress ID);

    /**
     * sets the state of the given contact to available or not available
     * @param contact the unique identifier of the contact whose state is to be altered
     * @param state the new state of the given contact
     * @return true if the state was successfully changed, false otherwise
     */
    boolean changeContactState(macaddress contact,boolean state);

    /**
     * adds a sent message to the list of sent and recieved messages of the given contact
     * @param contact who received the message
     * @param message that was sent
     * @return true if the message was succesfully added to the list, false otherwise
     */
    boolean addMessage(macaddress contact, String message);

    /**
     * delivers all the SUCCESSFULLY sent and received messages of the given contact
     * @param contact whose messages shall be shown
     * @return all the sent and received messages of the given contact
     */
    List<String> listOfMessages(macaddress contact);

    /**
     * this device receives a message from an available contact and saves it in the list of
     * sent and received messages of this contact
     * @param contact the device that sent this message
     * @param message
     * @return true if the received message was successfully saved, false otherwise
     */
    boolean addMessage(macaddress contact, String message);

}
