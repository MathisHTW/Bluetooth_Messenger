package main.model;

import java.util.List;

public interface model {

    //interface an Logic

    /**
     * if a new Contact/Channel makes himself visible to this device, this Method will add this Contact to the List of known contacts
     * @param name of the newly visible contact
     * @param contact unique identifier of the newly visible contact/channel
     * @return true if the new contact was successfully added to the list, false otherwise
     */
    boolean addContact(String name,int contact);

    /**
     * if a new Contact/Channel makes himself visible to this device, this Method will add this Contact to the List of known contacts
     * @param name of the newly visible channel
     * @param channel unique identifier of the newly visible contact/channel
     * @return true if the new channel was successfully added to the list, false otherwise
     */
    boolean addChannel(String name,int channel);

    /**
     * sets the name of this device/this devices channel
     * @param MyName the name of this device/this devices channel
     * @return true if the name was successfully saved, false otherwise
     */
    boolean setMyName(String MyName);

    /**
     * sets the ID of this devive/this devices channel to the given integer
     * @param MyID the id of this device
     * @return true if the ID was successfully saved, false otherwise
     */
    boolean setMyID(int MyID);

    /**
     * @return the name of this device
     */
    String getMyName();

    /**
     * @return the ID of this device/this devices channel
     */
    int getMyID();

    /**
     * used by Logic to deliver the AVAILABLE channels to the GUI to refresh the view
     * @return the list of names of the currently connected devices/channels
     */
    List<Channel> listOfChannels();

    /**
     * sets the state of the given contact to available or not available
     * @param contact the unique identifier of the contact whose state is to be altered
     * @param state the new state of the given contact
     * @return true if the state was successfully changed, false otherwise
     */
    boolean changeContactState(int contact,boolean state);

    /**
     * adds a sent message to the list of sent and recieved messages of the given contact
     * @param channel who received the message
     * @param message that was sent
     * @return true if the message was succesfully added to the list, false otherwise
     */
    boolean addMessage(int channel, String message);

    /**
     * delivers all the SUCCESSFULLY sent and received messages in a given channel
     * @param channel whose messages shall be shown
     * @return all the sent and received messages of a channel
     */
    List<Message> listOfMessages(int channel);

    /**
     * this device receives a message from an available contact and saves it in the list of
     * sent and received messages of the given channel
     * @param channel the channel in which the message was posted
     * @param message
     * @return true if the received message was successfully saved, false otherwise
     */
    boolean addMessage(int channel, message message);

}
