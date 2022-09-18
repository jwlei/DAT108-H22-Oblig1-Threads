package no.hvl.dat108.ex1.task2.models;

import no.hvl.dat108.ex1.task2.utility.PrintUtil;
import no.hvl.dat108.ex1.task2.utility.TimeUtil;

import java.util.LinkedList;


public class HamburgerTray {

    private TimeUtil timeUtil;
    private PrintUtil printUtil;
    private final int capacity;
    private LinkedList<Hamburger> hamburgerTray;

    /*
    public syncronized void myClass() {
        --> This method is synchronized and thread-safe
    }

    public void myClass() {
        --> synchronized (this) {
            This part is synchronized and thread-safe
        }
        This part isn't synchronized and thread-safe
    }

    @public void run() {
        for ( x : i ) {
        syncrhonized (counter) {
                coutner++ --> The counter object is synchronized
            }
        }
    }
     */

    public HamburgerTray(int i) {
        /**
         * Constructor
         * Create the track with a capacity of 4 hamburgers
         */
        hamburgerTray = new LinkedList<Hamburger>();
        capacity = i;
        this.timeUtil = new TimeUtil();
        this.printUtil = new PrintUtil();
    }


    public synchronized void printHamburgerTray() {
        /**
         * Prints the current status of the hamburgerTray
         */
        System.out.print("Hamburgers on the track: ");

        if (hamburgerTray.isEmpty()) {
            printUtil.printHamburgerTrayEmpty();
        }
        else {
            for (Hamburger hamburger : hamburgerTray) {
                // For each burger, print using @Overridden toString()
                System.out.print("[" + hamburger.toString() + "] ");
            }
         }
        System.out.println();
        }

    public synchronized boolean isFull() {
        /**
         * Checks if the que is full according to our specified capacity
         */
        return hamburgerTray.size() == capacity;
    }

    public synchronized void addHamburgerToTray(Hamburger hamburger) throws InterruptedException {
        /**
         * Function to add hamburger to the tray
         */
        while (isFull()) {
            // If full - wait untill notified.
            printUtil.printIsFull();
            printHamburgerTray();
            wait();
        }

        // Add the new hamburger last in the queue
        hamburgerTray.addLast(hamburger);
        printUtil.printAddHamburger(hamburger);
        printHamburgerTray();

        if (hamburgerTray.size() < capacity) {
            // The size of the linkedlist is less than our specified capacity
            // notify threads(chefs) that the tray is ready to receive hamburgers
            notify();
        }
    }

    public synchronized Hamburger removeHamburgerFromTray() throws InterruptedException {
        /**
         * Function for waiter to hamburger burger from tray and deliver to "customer"
         */
        while (hamburgerTray.isEmpty()) {
            // If no hamburgers, wait.
            printUtil.printIsEmpty();
            printHamburgerTray();
            wait();
        }

        // Remove hamburger from position 0 and decrement the Que counter.
        Hamburger deliver = hamburgerTray.removeFirst();

        if (hamburgerTray.size() <= capacity-1)
            // If there is a room in the queue, notify the sleeping threads(chefs)
            notify();

        printUtil.printRemoveHamburger(deliver);
        printHamburgerTray();
        return deliver;
    }
}
