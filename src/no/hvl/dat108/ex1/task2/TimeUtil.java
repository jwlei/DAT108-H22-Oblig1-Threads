package no.hvl.dat108.ex1.task2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class TimeUtil {

    private Random random = new Random();
    private final int minimumTimeToMake, maximumTimeToMake;
    public int timeToMake;

    public TimeUtil(int minimumTimeToMake, int maximumTimeToMake){
        this.minimumTimeToMake = minimumTimeToMake;
        this.maximumTimeToMake = maximumTimeToMake;
    }

    public String currentDateTime() {
        /**
         * Utility method for getting and parsing the current time.
         * For use in timestamps in the printed text.
         */
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");  //it will give you the date in the formate that is given in the image
        return dateformat.format(c.getTime());
    }

    public int timeToMake() {
        /**
         * Get a random time to make a hamburger
         * between 2-6 seconds
         */
        return timeToMake = random.nextInt((maximumTimeToMake - minimumTimeToMake) + 1) + minimumTimeToMake;
    }
}