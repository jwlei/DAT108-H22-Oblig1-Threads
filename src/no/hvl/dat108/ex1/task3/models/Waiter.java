package no.hvl.dat108.ex1.task3.models;

import no.hvl.dat108.ex1.task3.utility.PrintUtil;
import no.hvl.dat108.ex1.task3.utility.TimeUtil;

public class Waiter extends Thread {
    /**
     * Waiter threads
     * Removes hamburger from tray at customer order
     */
    private final HamburgerTray hamburgerTray;
    private final TimeUtil timeUtil;
    private String name;
    private int timeToMake;


    public Waiter(HamburgerTray hamburgerTray, String name, TimeUtil timeUtil) {
        this.setName(name);
        this.hamburgerTray = hamburgerTray;
        this.timeUtil = timeUtil;
    }


    public void run() {

        while (true) {
            try {
                int wait = timeUtil.TimeToMake();
                this.sleep(wait);
                hamburgerTray.removeHamburgerFromTray();
                //System.out.println(timeUtil.currentTimeStamp() + "Waiter " + Thread.currentThread().getName() + " doing the work");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
