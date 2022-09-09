package no.hvl.dat108.ex1.task3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Kokk extends Thread {

    private final BlockingQueue<Hamburger> bq;
    private Random random = new Random();
    private String name;

    public Kokk(BlockingQueue<Hamburger> bq, String name) {
        this.bq = bq;
        this.setName(name);

    }

    @Override
    public void run() {

        while(true) {

            try {
                Thread.sleep(random.nextInt(2000) + 4000);
                Hamburger nyHamburger = new Hamburger();
                if(bq.remainingCapacity() == 0) {
                    System.out.println(this.getName() + " Prøver å legge til " + nyHamburger.getType() + ", men brettet er fullt");
                }
                bq.put(nyHamburger);
                System.out.print(this.getName() + " legger til  [" + nyHamburger.getId() + "]" + nyHamburger.getType() + " => " + bq + "\n");



            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }
}
