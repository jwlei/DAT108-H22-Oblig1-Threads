package no.hvl.dat108.task2;

public class Chef implements Runnable {

    private String name;
    private HamburgerTray hamburgerTray;


    public Chef(HamburgerTray hamburgerTray, String name) {
        this.name = name;
        this.hamburgerTray = hamburgerTray;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);

        while(true) {
            try {
                int delay = randomTimerGenerator(2,6);
                Thread.sleep(delay);
                hamburgerTray.addBurger(new Hamburger());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return "Chef ( " + name + " ) ";
    }

    public int randomTimerGenerator(int min, int max) {
        int x = (int) ((Math.random() * ((max - min) + 1)) + min);
        return x * 1000;
    }


}



