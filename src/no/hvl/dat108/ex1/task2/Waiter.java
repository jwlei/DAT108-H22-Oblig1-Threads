package no.hvl.dat108.ex1.task2;

import java.util.Random;

public class Waiter {
    /**
     * Waiter threads
     * Removes hamburger from tray at customer order
     */
    private final HamburgerTray hamburgerTray;
    //private Random random = new Random();
    private String name;
    private int timeToMake;

    public Waiter(HamburgerTray hamburgerTray, String name) {
        this.setName(name);
        this.hamburgerTray = hamburgerTray;
    }

    private void setName(String name) {
    }


    // Todo: Remove burger
}
