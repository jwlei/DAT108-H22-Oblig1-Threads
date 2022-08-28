package no.hvl.dat108.ex1.task2;

import java.util.Random;

public class Chef extends Thread {
    /**
     * Chef threads
     *
     * Puts it on the hamburgertray when done
     */

    private final HamburgerTray hamburgerTray;
    //private Random random = new Random();
    private String name;
    private int timeToMake;



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