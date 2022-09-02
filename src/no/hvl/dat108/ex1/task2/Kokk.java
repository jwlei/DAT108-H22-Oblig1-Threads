package no.hvl.dat108.ex1.task2;

import java.util.Random;

public class Kokk extends Thread {
	private final HamburgerBrett hamburgerBrett;
    private Random random = new Random();
    private String name;

    public Kokk(HamburgerBrett hamburgerBrett, String name) {
        this.setName(name);
        this.hamburgerBrett = hamburgerBrett;
    }

    @Override
    public void run() {

        while(true) {

          //  Hamburger hamburger = makeHamburger();

            try {
                Thread.sleep(random.nextInt(4000) + 2000);
                hamburgerBrett.add(new Hamburger());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            hamburgerBrett.printTrack();
            System.out.println();
        }

    }

    private Hamburger makeHamburger() {
        return new Hamburger();
    }


	
}
