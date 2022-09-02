package no.hvl.dat108.ex1.task2;

public class HamburgerBrett {

	private int sisteIKø;
    private Hamburger[] hamburgerBrett;
    private Hamburger hamburger;

    public HamburgerBrett() {
        hamburgerBrett = new Hamburger[5];
        sisteIKø = 0;
    }

    public synchronized void add(Hamburger hamburger) throws InterruptedException {

        while (erFull()) {
            System.out.println(Thread.currentThread().getName() + " venter på å levere hamburger");
            wait();
        }
        hamburgerBrett[sisteIKø] = hamburger;
        sisteIKø++;
        System.out.print(Thread.currentThread().getName() + " legger på [" + hamburger.getId()+"]" + hamburger.getType() + " => ");
        if (sisteIKø == 1)
            notify();

    }

    public synchronized Hamburger getHamburger() throws InterruptedException {

        while (isEmpty()) {
            System.out.println(Thread.currentThread().getName() + "ønsker å ta hamburger, men brettet er tomt. Venter!");
            wait();
        }
        Hamburger ut = hamburgerBrett[0];
        sisteIKø--;

        for(int i = 0; i < sisteIKø; i++) {
            hamburgerBrett[i] = hamburgerBrett[i+1];
        }
        hamburgerBrett[sisteIKø] = null;
        System.out.print(Thread.currentThread().getName() + " henter [" + ut.getId() + "]" + ut.getType() + " <= ");
        if (sisteIKø == 4)
            notify();
        return ut;
    }

    public String peek() {
        return hamburgerBrett[0].getType();
    }

    public synchronized boolean erFull() {
        return sisteIKø == 5;
    }

    public synchronized boolean isEmpty() { return hamburgerBrett[0] == null; }

    public synchronized void printTrack() {

        System.out.print("Hamburger er på brettet: ");

        for(int i = 0; i < sisteIKø; i++) {

            System.out.print("[" + hamburgerBrett[i].getId() + "]" +hamburgerBrett[i].getType() + " ");
        }
    }

}