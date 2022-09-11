package no.hvl.dat108.ex1.task3.models;

public class Hamburger {
    private static int hamburgerNumber = 0;
    private int id;
    private String hamburgerId;

    public Hamburger() {
        /**
         * Incrementer for the id of the hamburger created
         * to keep track of how many burgers we have made
         */
        id = ++hamburgerNumber;
    }

    public String getId() {
        return hamburgerId = "HamburgerID: " + id;
    }
}
