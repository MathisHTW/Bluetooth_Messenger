package main.controller.logic.CRUD;

interface ICreate {

    /**
     * Create a Channel and add this to Storage
     *
     * @param name
     * @return if true | false = something is wrong
     */
    boolean createChannel(String name);

    /**
     * Create a User and add this to storage
     *
     * @param name
     * @return if true | false = something is wrong
     */
    boolean createUser(String name);

    /**
     * Create a Notification for Messages
     *
     * @param name
     * @param text
     * @return if true | false = something is wrong
     */
    boolean createMessage(String name, String text);
}
