package no.hvl.dat108.ex1.task3.models;

import no.hvl.dat108.ex1.task3.utility.PrintUtil;
import no.hvl.dat108.ex1.task3.utility.TimeUtil;

import java.util.concurrent.BlockingQueue;

public class Waiter extends Thread {
    /**
     * Waiter threads
     * Removes hamburger from tray at customer order
     */
    private final TimeUtil timeUtil;
    private final PrintUtil printUtil = new PrintUtil();
    BlockingQueue<Hamburger> blockingQueue;


    public Waiter(BlockingQueue<Hamburger> blockingQueue, String name, TimeUtil timeUtil) {
        this.blockingQueue = blockingQueue;
        this.setName(name);
        this.timeUtil = timeUtil;
    }


    public void removeHamburgerFromTray() throws InterruptedException {
        /**
         * Function for waiter to hamburger burger from tray and deliver to "customer"
         */
        try {
            Hamburger deliveredHamburger = blockingQueue.take();
            printUtil.printRemoveHamburger(deliveredHamburger);
            printUtil.printHamburgerTray(blockingQueue);

        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public void run() {
        while (true) {
            try {
                this.sleep(timeUtil.TimeToMake());
                removeHamburgerFromTray();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
