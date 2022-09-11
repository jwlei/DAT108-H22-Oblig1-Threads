package no.hvl.dat108.ex1.task3.models;

import no.hvl.dat108.ex1.task3.utility.PrintUtil;
import no.hvl.dat108.ex1.task3.utility.TimeUtil;

import java.util.concurrent.BlockingQueue;

public class Chef extends Thread {
    /**
     * Chef threads
     * Puts it on the hamburgertray when done
     */

    private final TimeUtil timeUtil;
    private final PrintUtil printUtil = new PrintUtil();
    BlockingQueue<Hamburger> blockingQueue;


    public Chef(BlockingQueue<Hamburger> blockingQueue, String name, TimeUtil timeUtil) {
        this.setName(name);
        this.blockingQueue = blockingQueue;
        this.timeUtil = timeUtil;
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
         */
        try {
            blockingQueue.put(hamburger);
            printUtil.printAddHamburger(hamburger);
            printUtil.printHamburgerTray(blockingQueue);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while(true) {
            try {
                // WAIT
                sleep(timeUtil.TimeToMake());
                // CREATE AND ADD HAMBURGER
               addHamburgerToTray(new Hamburger());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}