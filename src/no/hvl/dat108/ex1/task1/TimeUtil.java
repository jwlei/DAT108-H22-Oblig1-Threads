package no.hvl.dat108.ex1.task1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtil {
    public String currentDateTime() {
        /**
         * Utility method for getting and parsing the current time.
         * For use in timestamps in the printed text.
         */
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");  //it will give you the date in the formate that is given in the image
        return dateformat.format(c.getTime());
    }
}