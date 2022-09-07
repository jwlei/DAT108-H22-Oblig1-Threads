package no.hvl.dat108.task2;

public class Waiter implements Runnable {

    private String name;
    private HamburgerTray hamburgerTray;


    public Waiter(HamburgerTray hamburgerTray, String name) {
        this.name = name;
        this.hamburgerTray = hamburgerTray;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);

        while (true) {
            try {
                int delay = randomTimerGenerator(2,6);
                Thread.sleep(delay);
                hamburgerTray.takeBurger();
            } catch (InterruptedException e) {

            }
        }
        // Check to see if there are any burgers
        // then serve a burger

    }

    public int randomTimerGenerator(int min, int max) {
        int x = (int) ((Math.random() * ((max - min) + 1)) + min);
        return x * 1000;
    }


    @Override
    public String toString() {
        return "Waiter ( " + name + " ) ";
    }
}
