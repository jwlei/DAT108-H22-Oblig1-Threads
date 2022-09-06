package no.hvl.dat108.ex1.task3.models;


import no.hvl.dat108.ex1.task3.utility.PrintUtil;
import no.hvl.dat108.ex1.task3.utility.TimeUtil;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class HamburgerTray {

    private TimeUtil timeUtil;
    private PrintUtil printUtil;
    private final int capacity;
    private int lastInQue;
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

    public HamburgerTray(int i) {
        /**
         * Create the track with a capacity of 4 hamburgers
         */
        hamburgerTray = new LinkedBlockingDeque<>(i);
        capacity = i;
        this.timeUtil = new TimeUtil();
        this.printUtil = new PrintUtil();
    }


    public void printHamburgerTray(Hamburger hamburger) {
        /**
         * Prints the current status of the hamburgerTray
         */
        System.out.print("Hamburgers on the track: ");
        Iterator<Hamburger> hamburgerOnTray = hamburgerTray.iterator();

        while (hamburgerOnTray.hasNext())
            System.out.print("[" + hamburgerOnTray.next() + "] ");
        System.out.println();
        }


    public void addHamburgerToTray(Hamburger hamburger) throws InterruptedException {
        /**
         * Function to add hamburger to the tray
         */
        hamburgerTray.put(hamburger);
        printUtil.printAddHamburger(hamburger);
        printHamburgerTray(hamburger);
    }

    public void removeHamburgerFromTray() throws InterruptedException {
        /**
         * Function for waiter to hamburger burger from tray and deliver to "customer"
         */
        Hamburger deliver = hamburgerTray.take();
        printUtil.printRemoveHamburger(deliver);
        printHamburgerTray(deliver);
    }

}
