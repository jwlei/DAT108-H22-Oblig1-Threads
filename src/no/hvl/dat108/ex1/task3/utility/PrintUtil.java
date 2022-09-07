package no.hvl.dat108.ex1.task3.utility;

import no.hvl.dat108.ex1.task3.models.Hamburger;

import java.util.concurrent.BlockingQueue;

public class PrintUtil {
    private TimeUtil timeUtil;


    public PrintUtil() {
        this.timeUtil = new TimeUtil();
    }

    public void printAddHamburger(Hamburger hamburger){
        System.out.print(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " puts [" + hamburger.getId() + "]" + " => ");
    }

    public void printRemoveHamburger(Hamburger hamburger){
        System.out.print(timeUtil.currentTimeStamp() + Thread.currentThread().getName() + " takes [" + hamburger.getId() + "]" + " <= ");
    }

    public void printHamburgerTray(BlockingQueue<Hamburger> blockingQueue) {
        /**
         * Prints the current status of the hamburgerTray
         */
        System.out.print("Hamburgers on the track: ");

        if (blockingQueue.isEmpty()) {
            System.out.print("[ ] ");
        }
        else {
            for (Hamburger hamburger : blockingQueue ) {
                System.out.print("[" + hamburger.getId() + "] ");
            }
        }
        System.out.println();
    }
}
