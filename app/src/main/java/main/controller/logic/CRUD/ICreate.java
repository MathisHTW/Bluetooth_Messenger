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
}
