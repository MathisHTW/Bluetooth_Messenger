package main.modell.data;

import java.util.Date;

class Ultis {

    static String generatID(String value) {
        final long minTime = System.currentTimeMillis();
        final Date date = new Date();
        final int number = 100000;
        final double random = Math.random() * number;

        StringBuffer stringBuffer = new StringBuffer();
        if (null != value) {
            stringBuffer.append(value);
        }
        stringBuffer.append(date);
        stringBuffer.append(minTime);
        stringBuffer.append(random);

        return stringBuffer.toString();
    }

    @Deprecated
    /**
     * creates a unique URI for this device to be used as a unique identifier of
     * the channel of this device
     *
     * @param channelName the name of the channel that is entered into the UI
     * @return URI for this device
     */
    public String createURI(String channelName) {
        final int randomSize = 1000000;
        String myURI = "Bluetooth_Messenger://" + channelName;

        int random = (int) (Math.random() * randomSize);
        Date date = new Date();
        long timeInMillis = date.getTime();

        myURI = myURI + random;
        myURI = myURI + timeInMillis;

        return myURI;
    }
}
