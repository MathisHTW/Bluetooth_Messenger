package main.modell.data;

public interface INotification {

    /**
     * Get ID of notification
     * @return id
     */
    String getID();

    /**
     * Get Name of notification
     * @return name
     */
    String getName();

    /**
     * Get text of notification
     * @return text
     */
    String getText();
}
