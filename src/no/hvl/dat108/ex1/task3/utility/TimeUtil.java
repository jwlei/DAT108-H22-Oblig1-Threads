package no.hvl.dat108.ex1.task3.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class TimeUtil {

    private Random random = new Random();
    private int minimumTimeToMake = 2000;
    private int maximumTimeToMake = 4000;
    public int timeToMake;

    public TimeUtil(){}
    public TimeUtil(int minimumTimeToMake, int maximumTimeToMake){
        this.minimumTimeToMake = minimumTimeToMake;
        this.maximumTimeToMake = maximumTimeToMake;
    }

    public String currentTimeStamp() {
        /**
         * Utility method for getting and parsing the current time.
         * For use in timestamps in the printed text.
         */
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("[HH:mm:ss] ");
        return dateformat.format(c.getTime());
    }

    public int TimeToMake() {
        /**
         * Get a random time to make a hamburger
         * between 2-6 seconds
         */
        return timeToMake =  2000 + random.nextInt(4000);
        //return timeToMake = random.nextInt((maximumTimeToMake - minimumTimeToMake) + minimumTimeToMake);
    }
}