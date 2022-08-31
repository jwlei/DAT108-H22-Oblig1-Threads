package no.hvl.dat108.ex1.task2.models;


import no.hvl.dat108.ex1.task2.utility.PrintUtil;
import no.hvl.dat108.ex1.task2.utility.TimeUtil;

public class HamburgerTray {

    private TimeUtil timeUtil;
    private PrintUtil printUtil;
    private final int capacity;
    private int lastInQue;
    private Hamburger[] hamburgerTray;



    public HamburgerTray(int i) {
        /**
         * Create the track with a capacity of 4 hamburgers
         */
        hamburgerTray = new Hamburger[i];
        lastInQue = 0;
        capacity = i;
        this.timeUtil = new TimeUtil();
        this.printUtil = new PrintUtil();
    }

    public synchronized void printHamburgerTray() {
        /**
         * Prints the current status of the hamburgerTray
         */
        // TODO: Migrate to printUtil?
        System.out.print(timeUtil.currentTimeStamp() + "Hamburgers on the track: ");

        if (hamburgerTray[0] == null) {
            printUtil.printHamburgerTrayEmpty();
        }
        else {
            for(int i = 0; i < lastInQue; i++) {

                // For each burger, get ID and print.
                System.out.print("[" + hamburgerTray[i].getId() + "] ");
            }
         }
        System.out.println();
        }

    public synchronized boolean isEmpty() {
        /**
         * Checks if the que is empty
         */
        return hamburgerTray[0] == null; }

    public synchronized boolean isFull() {
        /**
         * Checks if the que is full
         */
        return lastInQue == capacity;
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

        hamburgerTray[lastInQue] = hamburger;
        lastInQue++;
        printUtil.printAddHamburger(hamburger);
        printHamburgerTray();

        if (lastInQue == 1)
            // If last in que == 1, notify threads(chefs) that the tray is ready to receive hamburgers
            notify();

    }

    public synchronized Hamburger removeHamburgerFromTray() throws InterruptedException {
        /**
         * Function for waiter to hamburger burger from tray and deliver to "customer"
         */
        while (isEmpty()) {
            // If no hamburgers, wait.
            printHamburgerTray();
            printUtil.printIsEmpty();
            wait();
        }

        // Remove hamburger from position 0 and decrement the Que counter.
        Hamburger deliver = hamburgerTray[0];
        lastInQue--;

        // For each element,
        for(int i = 0; i < lastInQue; i++) {
            // Move each Hamburger in the que
            // e.g. The hamburger that was in slot 0 is delivered, move hamburger in slot 1 --> 0.
            // Simulates a LIFO Que
            hamburgerTray[i] = hamburgerTray[i+1];
        }
        hamburgerTray[lastInQue] = null;

        if (lastInQue == capacity-1)
            // If there is a room in the que, notify the sleeping threads(chefs)
            notify();

        printUtil.printRemoveHamburger(deliver);
        printHamburgerTray();
        return deliver;
    }

}
