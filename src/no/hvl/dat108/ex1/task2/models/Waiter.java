package no.hvl.dat108.ex1.task2.models;

import no.hvl.dat108.ex1.task2.utility.TimeUtil;

public class Waiter extends Thread {
    /**
     * Waiter threads
     * Removes hamburger from tray at customer order
     */
    private final HamburgerTray hamburgerTray;
    private final TimeUtil timeUtil;



    public Waiter(HamburgerTray hamburgerTray, String name, TimeUtil timeUtil) {
        /**
         * Constructor
         */
        this.setName(name);
        this.hamburgerTray = hamburgerTray;
        this.timeUtil = timeUtil;
    }


    public void run() {
        while (true) {
            try {
                // WAIT
                this.sleep(timeUtil.TimeToMake());
                // REMOVE HAMBURGER
                hamburgerTray.removeHamburgerFromTray();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
