package main.Logic;

import java.util.List;

public interface Logic {

    //inteface to GUI////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * enables Bluetooth and informs all available devices about the new participant by broadcasting the name
     * and other relevant information, like an unique identifier to enable future communication in a channel that has the same name and
     * identifier as the contact of this device
     * @param name of this device/channel, visible for all connected devices
     * @return true when Bluetooth is enabled and the name was sent to all available devices
     */
    boolean openChannel(String name);

    /**
     * used by GUI to refresh the available channels
     * @return the list of names and Ids of the currently connected devices/channels
     */
    List<Channel> listChannels();

    /**
     * sends the given message into a known and available channel
     * @param channel unique identifier of the message receiver
     * @param message that is to be sent
     * @return true if the message was successfully delivered, false if there is a time out
     */
    boolean sendMessage(int channel, String message);

    /**
     * delivers all the successfully sent and received messages of the given channel
     * @param channel whose messages shall be shown
     * @return all the sent and received messages of the given channel
     */
    List<String> listMessages(int channel);

    //interface to network///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * if a new contact/channel makes himself visible to this device, this Method will add this contact to the List of known contacts
     * @param name of the newly visible contact
     * @param contact unique identifier of the newly visible contact
     * @return true if the new contact was successfully added to the list of contacts or if it is already saved, false otherwise
     */
    boolean addContact(String name,int contact);

    /**
     * if a new contact/channel makes himself visible to this device, this Method will add this channel to the List of known channels
     * @param name of the newly visible channel
     * @param channel unique identifier of the newly visible channel
     * @return true if the new channel was successfully added to the list of channels or if it is already saved, false otherwise
     */
    boolean addChannel(String name,int channel);

    /**
     * this device receives a message from an available channel and saves it in the list of
     * sent and received messages of this channel
     * @param channel the channel in which the message was posted
     * @param message the content of the message
     * @return true if the received message was successfully saved, false otherwise
     */
    boolean receiveMessage(int channel,message message);

}
