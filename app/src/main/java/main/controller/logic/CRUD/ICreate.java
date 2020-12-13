package main.controller.logic.CRUD;

interface ICreate {

    /**
     * Create a Channel and add this to Storage
     *
     * @param name
     */
    boolean createChannel(String name);

    /**
     * Create a User and add this to storage
     *
     * @param name
     */
    boolean createUser(String name);

    /**
     * creates a unique URI for this device to be used as a unique identifier of
     * the channel of this device
     * @param channelName the name of the channel that is entered into the UI
     * @return URI for this device
     */
    String createURI(String channelName);
}
