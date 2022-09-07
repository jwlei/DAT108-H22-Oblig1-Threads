package no.hvl.dat108.ex1.task3;

import no.hvl.dat108.ex1.task3.models.Chef;
import no.hvl.dat108.ex1.task3.models.Hamburger;
import no.hvl.dat108.ex1.task3.models.Waiter;
import no.hvl.dat108.ex1.task3.utility.TimeUtil;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Components of the application:
         * HamburgerTray    --> A que for hamburgers
         * Chefs            --> Creates hamburgers and puts them on the tray when done
         * Waiters          --> Removes hamburgers from the tray when a "customer" buys a hamburger
         */

        final String[] chefs = {"Joachim", "Finn", "Sindre"};
        final String[] waiters = {"Pernille", "Sara"};
        final int capacity = 4;
        final int minimumTimeToMake = 2000, maximumTimeToMake = 6000; // In milliseconds
        TimeUtil timeUtil = new TimeUtil(minimumTimeToMake, maximumTimeToMake);
        BlockingQueue<Hamburger> blockingQueue = new ArrayBlockingQueue<>(capacity);


        //Init print
        System.out.println(timeUtil.currentTimeStamp() + "Chefs: " + Arrays.toString(chefs) + "\n"
                            + timeUtil.currentTimeStamp() + "Waiters: " +Arrays.toString(waiters) + "\n"
                            + timeUtil.currentTimeStamp() + "Capacity of the hamburger tray is: " + (capacity) + " hamburgers\n"
                            + " --- --- --- --- --- --- --- --- --- --- ");


        // 3 Chefs
        for (String name : chefs) {
            /*
              Start all chef threads
             */
            String role = "[Chef] ";
            name = role+=name;
            new Chef(blockingQueue, name, timeUtil).start();
            System.out.println(timeUtil.currentTimeStamp() + name + " is ready to work");
        }

        // 2 Waiters
        for (String name : waiters) {
            /*
              Start all waiter threads
             */
            String role = "[Waiter] ";
            name = role+=name;
            new Waiter(blockingQueue, name, timeUtil).start();
            System.out.println(timeUtil.currentTimeStamp() + name + " is ready to work");
        }

        System.out.println(" --- --- --- --- --- --- --- --- --- --- ");

    }
}
