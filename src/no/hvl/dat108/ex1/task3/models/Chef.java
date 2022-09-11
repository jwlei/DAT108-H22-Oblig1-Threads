package no.hvl.dat108.ex1.task3.models;

import no.hvl.dat108.ex1.task3.utility.PrintUtil;
import no.hvl.dat108.ex1.task3.utility.TimeUtil;

import java.util.concurrent.BlockingQueue;

public class Chef extends Thread {
    /**
     * Chef threads
     * Puts it on the hamburgertray when done
     */

    private final TimeUtil timeUtil = new TimeUtil();
    private final PrintUtil printUtil = new PrintUtil();
    private BlockingQueue<Hamburger> blockingQueue;


    public Chef(BlockingQueue<Hamburger> blockingQueue, String name) {
        /**
         * Constructor
         */
        this.setName(name);
        this.blockingQueue = blockingQueue;
    }


    private Hamburger createHamburger() {
        /**
         * Creates and returns a new hamburger when called
         */
        return new Hamburger();
    }


    public void addHamburgerToTray(Hamburger hamburger) throws InterruptedException {
        /**
         * Function to add hamburger to the tray
         * .put(object) adds object to the queue,
         * if the queue is full, waits until there is a spot available
         */
        blockingQueue.put(hamburger);
        printUtil.printAddHamburger(hamburger);
        printUtil.printHamburgerTray(blockingQueue);
    }


    @Override
    public void run() {
        while(true) {
            try {
                // WAIT
                Thread.sleep(timeUtil.TimeToMake());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            try {
                // CREATE AND ADD HAMBURGER
                addHamburgerToTray(new Hamburger());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}