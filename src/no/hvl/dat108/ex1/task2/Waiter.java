package no.hvl.dat108.ex1.task2;

import java.util.Random;

public class Waiter extends Thread {
    /**
     * Waiter threads
     * Removes hamburger from tray at customer order
     */
    private final HamburgerTray hamburgerTray;
    private final TimeUtil timeUtil;
    //private Random random = new Random();
    private String name;
    private int timeToMake;


    public Waiter(HamburgerTray hamburgerTray, String name, TimeUtil timeUtil) {
        this.setName(name);
        this.hamburgerTray = hamburgerTray;
        this.timeUtil = timeUtil;
    }


    public void run() {
        // TODO
        // wait timeTomMake x
        // removeBurger x

        // print?
        while (true) {
            try {
                int wait = timeUtil.TimeToMake();
                this.sleep(wait);
                // Todo: Remove burger - made in hamburgerTRAY class
                hamburgerTray.removeHamburgerFromTray();
                //System.out.println(timeUtil.currentTimeStamp() + "Waiter " + Thread.currentThread().getName() + " doing the work");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hamburgerTray.printHamburgerTray();
            System.out.println(); // empty line for formatting
        }




    }
}
