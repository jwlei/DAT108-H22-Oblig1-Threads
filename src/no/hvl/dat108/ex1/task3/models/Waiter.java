package no.hvl.dat108.ex1.task3.models;

import no.hvl.dat108.ex1.task3.utility.PrintUtil;
import no.hvl.dat108.ex1.task3.utility.TimeUtil;

import java.util.concurrent.BlockingQueue;

public class Waiter extends Thread {
    /**
     * Waiter threads
     * Removes hamburger from tray at customer order
     */
    private final TimeUtil timeUtil = new TimeUtil();
    private final PrintUtil printUtil = new PrintUtil();
    private BlockingQueue<Hamburger> blockingQueue;


    public Waiter(BlockingQueue<Hamburger> blockingQueue, String name) {
        /**
         * Constructor
         */
        this.blockingQueue = blockingQueue;
        this.setName(name);

    }

    public void removeHamburgerFromTray() throws InterruptedException {
        /**
         * Function for waiter to hamburger burger from tray and deliver to "customer"
         * .take() - Takes the head of the que, if empty, waits until available.
         */
        Hamburger deliveredHamburger = blockingQueue.take();
        try {
            printUtil.printRemoveHamburger(deliveredHamburger);
            printUtil.printHamburgerTray(blockingQueue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void run() {
        while (true) {
            try {
                // WAIT
                System.out.println(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " is sleeping ...");
                Thread.sleep(timeUtil.TimeToMake());
                System.out.println(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " is AWAKE");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            try {
                // REMOVE HAMBURGER FROM TRAY
                removeHamburgerFromTray();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
