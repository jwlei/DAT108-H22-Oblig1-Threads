package no.hvl.dat108.ex1.task2;

public class HamburgerTray {

    private int lastInQue;
    private Hamburger[] hamburgerTray;
    private Hamburger hamburger;
    private int capacity;
    private TimeUtil timeUtil;

    public HamburgerTray(int i) {
        /**
         * Create the track with a capacity of 4 hamburgers
         */
        hamburgerTray = new Hamburger[i];
        lastInQue = 0;
        capacity = i;
        this.timeUtil = new TimeUtil();

    }

    // TODO: isEmpty
    public synchronized boolean isEmpty() {
        /**
         * Checks if the que is empty
         */
        return hamburgerTray[0] == null; }

    // TODO: isFull
    public synchronized boolean isFull() {
        /**
         * Checks if the que is full
         */
        return lastInQue == capacity;
    }

    // TODO: Print --> adding/removing hamburger, status of the tray, action on isFull/isEmpty
    public synchronized void printHamburgerTray() {
        /**
         * Prints the current status of the hamburgerTray
         */
        System.out.print(timeUtil.currentTimeStamp() + "Hamburgers on the track: ");

        for(int i = 0; i < lastInQue; i++) {
            // For each burger, get ID and print.
            System.out.print(timeUtil.currentTimeStamp() + "[" + hamburgerTray[i].getId() + "]" + " ");
        }
    }

    // TODO: Add burger
    public synchronized void addHamburgerToTray(Hamburger hamburger) throws InterruptedException {
        /**
         * Function to add hamburger to the tray
         */
        while (isFull()) {
            // If full - wait untill notified.
            System.out.println(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " waiting to deliver hamburger to the tray");
            wait();
        }
        hamburgerTray[lastInQue] = hamburger;
        lastInQue++;
        System.out.print(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " adds a [" +hamburger.getId()+"]" + " => ");

        if (lastInQue == 1)
            // If last in que == 1, notify chefs that the tray is ready to receive hamburgers
            notify();

    }

    // TODO: get burger
    public synchronized Hamburger removeHamburgerFromTray() throws InterruptedException {
        /**
         * Function for waiter to hamburger burger from tray and deliver to "customer"
         */
        while (isEmpty()) {
            // If no hamburgers, wait.
            printHamburgerTray();
            System.out.println(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " waiting to collect a hamburger from the tray");
            wait();
        }
        // Remove hamburger from position 0 and decrement the last in que counter.
        Hamburger deliver = hamburgerTray[0];
        lastInQue--;

        for(int i = 0; i < lastInQue; i++) {
            hamburgerTray[i] = hamburgerTray[i+1];
        }
        hamburgerTray[lastInQue] = null;

        System.out.print(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " collects [" + deliver.getId() + "]" + " <= ");
        if (lastInQue == capacity-1)
            notify();

        return deliver;
    }

}
