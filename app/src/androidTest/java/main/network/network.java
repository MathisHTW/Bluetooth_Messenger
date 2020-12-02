package main.network;

import java.util.List;

public interface network {
    //network interface for the Logic

    /**
     * asks all availabe devices for their unique channel ids and returns a List of these IDs
     * that way the logic can decide which id to pick that is not used yet
     * @return List of already used Ids
     */
    List<Integer> usedIDs();

    /**
     * takes the unique ID and the name of this device and broadcasts it to all available devices
     * to enable future communication in this channel
     * @param name of this device/this devices channel
     * @param myID unique identifier of this device/this devices channel
     */
    void openChannel(String name, int myID);

    /**
     * if this device recieves the information that a new device is available, it sends its name and
     * channel/contact ID to the new device
     * @param myName name of this device
     * @param myID channel/contactID of this device
     * @return if the information was successfully delivered to the newly available device
     */
    boolean respondToNewDevice(String myName,int myID);

    /**
     * checks if a known contact/channel is still available by sending a minimal request to the other device
     * @param channel unique identifier of the contact/channel that is to be checked up on
     * @return true if the contact/channel is still available, false if the request times out
     */
    boolean channelActive(int channel);

    /**
     * sends the given message into the known and available channel
     * @param channel unique identifier of the message receiver
     * @param message that is to be sent
     * @return true if the message was successfully delivered, false if there is a time out
     */
    boolean sendMessage(int channel, message message);
}
