package main3.modell.data;

import java.util.Date;

class Ultis {

    public static String generatID(String value) {
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

}
