package no.hvl.dat108.ex1.task2;

import java.util.Random;

public class Chef extends Thread {
    /**
     * Chef threads
     * Creates hamburgers on a random time 2-6 seconds
     * Puts it on the hamburgertray when done
     */

    private final HamburgerTray hamburgerTray;
    private Random random = new Random();
    private String name;
    private int minimumTimeToMake = 2, maximumTimeToMake = 6, timeToMake;

    private int timeToMake(int minimumTimeToMake, int maximumTimeToMake) {
        /**
         * Get a random time to make a hamburger
         * between 2-6 seconds
         */
        return timeToMake = random.nextInt((maximumTimeToMake - minimumTimeToMake) + 1) + minimumTimeToMake;
    }

    public Chef(HamburgerTray hamburgerTray, String name) {
        this.setName(name);
        this.hamburgerTray = hamburgerTray;
    }

    private Hamburger createHamburger() {
        // TODO
        return null;
    }

    @Override
    public void run() {
        // TODO
        // make burger
            // wait timeTomMake
                // addBurger

        // print?
    }
}