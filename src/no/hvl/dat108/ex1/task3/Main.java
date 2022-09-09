package no.hvl.dat108.ex1.task3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {

        BlockingQueue<Hamburger> bq = new LinkedBlockingQueue<Hamburger>(5);

        Kokk kokk1 = new Kokk(bq,"Anne (kokk)");
        Kokk kokk2 = new Kokk(bq,"Erik (kokk)");
        Kokk kokk3 = new Kokk(bq, "Knut (kokk)");
        Servitor servitor1 = new Servitor(bq, "Mia (servitor)");
        Servitor servitor2 = new Servitor(bq, "Per (servitor)");

        servitor1.start();
        servitor2.start();
        kokk1.start();
        kokk2.start();
        kokk3.start();

    }
}