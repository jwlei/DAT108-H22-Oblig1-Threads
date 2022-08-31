package no.hvl.dat108.ex1.task2;

import java.util.Random;

public class Chef extends Thread {
    /**
     * Chef threads
     * Puts it on the hamburgertray when done
     */

    private final HamburgerTray hamburgerTray;
    private final TimeUtil timeUtil;
    private String name;
    private int timeToMake;



    public Chef(HamburgerTray hamburgerTray, String name, TimeUtil timeUtil) {
        this.setName(name);
        this.hamburgerTray = hamburgerTray;
        this.timeUtil = timeUtil;
    }

    private Hamburger createHamburger() {
        /**
         * Creates and returns a new hamburger when called
         */
        return new Hamburger();
    }

    @Override
    public void run() {
        while(true) {
            try {
                // WAIT
                int wait = timeUtil.TimeToMake();
                this.sleep(wait);
                // CREATE AND ADD HAMBURGER
                hamburgerTray.addHamburgerToTray(new Hamburger());
                //Test line - System.out.println(timeUtil.currentTimeStamp() + "Chef " + Thread.currentThread().getName() + " doing the work");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}