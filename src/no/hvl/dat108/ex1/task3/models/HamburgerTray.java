package no.hvl.dat108.ex1.task3.models;


import no.hvl.dat108.ex1.task3.utility.PrintUtil;
import no.hvl.dat108.ex1.task3.utility.TimeUtil;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class HamburgerTray {

    private TimeUtil timeUtil;
    private PrintUtil printUtil;
    private BlockingQueue<Hamburger> hamburgerTray;

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

    public HamburgerTray(int capacity) {
        /**
         * Create the track with a capacity of 4 hamburgers
         */
        this.hamburgerTray = new LinkedBlockingDeque<>(capacity);
        this.timeUtil = new TimeUtil();
        this.printUtil = new PrintUtil();
    }


    public void printHamburgerTray() {
        /**
         * Prints the current status of the hamburgerTray
         */
        System.out.print("Hamburgers on the track: ");
        Iterator<Hamburger> hamburgerOnTray = hamburgerTray.iterator();

        if (hamburgerTray.isEmpty()) {
            System.out.print("[ ] ");
            }
        else {
            while (hamburgerOnTray.hasNext()) {
                System.out.print("[" + hamburgerOnTray.next().getId() + "] ");
                }
            }
        System.out.println();
        }


    public void addHamburgerToTray(Hamburger hamburger) throws InterruptedException {
        /**
         * Function to add hamburger to the tray
         */
        hamburgerTray.put(hamburger);
        printUtil.printAddHamburger(hamburger);
        printHamburgerTray();
    }

    public void removeHamburgerFromTray() throws InterruptedException {
        /**
         * Function for waiter to hamburger burger from tray and deliver to "customer"
         */
        Hamburger deliveredHamburger = hamburgerTray.take();
        printUtil.printRemoveHamburger(deliveredHamburger);
        printHamburgerTray();
    }

}
