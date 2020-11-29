package main.network;

public interface network {
    //network interface for the Logic

    /**
     * takes the unique ID and the name of this device and broadcasts it to all connected devices
     * to enable future communication
     * @param Name of this device
     * @param ID unique identifier of this device
     */
    void iAmNewHere(String Name, macadress ID);

    /**
     * checks if a known contact is still available by sending a minimal request to the other device
     * @param contact unique identifier of the contact that is to be checked up on
     * @return true if the contact is still available, false if the request times out
     */
    boolean areYouStillThere(macadress contact);

    /**
     * sends the given message to the known and available contact
     * @param contact unique identifier of the message receiver
     * @param message that is to be sent
     * @return true if the message was successfully delivered, false if there is a time out
     */
    boolean sendMessage(macadress contact, String message);
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //interface for the network of the other devices
    /**
     * if a new Contact makes himself visible to this device, this Method will add this Contact to the List of known contacts
     * @param name of the newly visible contact
     * @param contact unique identifier of the newly visible contact
     * @return true if the new contact was successfully added to the list, false otherwise
     */
    boolean addContact(String name,macadress contact); //boolean oder lieber void??
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
