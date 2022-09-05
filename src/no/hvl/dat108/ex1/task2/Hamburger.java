package no.hvl.dat108.ex1.task2;

public class Hamburger {

    private int hamburgerId;
    private static int burgerNr;
    public Hamburger() {
        synchronized (Hamburger.class) {
            burgerNr++;
            hamburgerId = burgerNr;
        }
    }

    @Override
    public String toString() {
        return "(Hamburger " + hamburgerId + ")";
    }
}
