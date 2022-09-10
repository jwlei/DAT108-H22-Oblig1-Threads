package no.hvl.dat108.task3;

public class Hamburger {

    private final int hamburgerId;
    private static int burgerNr;
    public Hamburger() {
            burgerNr++;
            hamburgerId = burgerNr;
    }

    @Override
    public String toString() {
        return "(Hamburger " + hamburgerId + ")";
    }
}
