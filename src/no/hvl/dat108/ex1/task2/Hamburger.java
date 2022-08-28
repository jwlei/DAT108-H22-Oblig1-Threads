package no.hvl.dat108.ex1.task2;

public class Hamburger {

    private static int hamburgerNumber = 0;
    private int id;

    Hamburger() {
        /**
         * Incrementer for the id of the hamburger created
         * to keep track of how many burgers we have
         */
        id = ++hamburgerNumber;
    }


    public int getId() {
        return id;
    }
}
