package no.hvl.dat108.ex1.task2;

import java.sql.Time;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Components of the application:
         * HamburgerTray    --> A que for hamburgers
         * Chefs            --> Creates hamburgers and puts them on the tray when done
         * Waiters          --> Removes hamburgers from the tray when a "customer" buys a hamburger
         */

        /*
        Krav til programmet
         Både Hamburger, HamburgerBrett, Kokk og Servitor skal være klasser i programmet
        slik det er naturlig. Kokker og servitører er tråder, mens brettet er en delt ressurs
        som både kokker og servitører forholder seg til.

         De ulike objektene i programmet skal samarbeide via referanser til hverandre, ikke
        gjennom globale variabler.

         Programmet må være trådsikkert slik at det ikke blir rot i tellingen og i køen av
        hamburgere. Kokker og servitører må vente hvis det er nødvendig, ikke bare kjøre
        videre.

         Hvis brettet er tomt, må servitører vente til det er lagt en ny hamburger på, og hvis
        brettet er fullt, må kokker vente til det er tatt en hamburger av.

         Det er meningen at dere skal bruke tråd-primitivene synchronized, wait, notify og
        notifyAll til å løse oppgaven. Dere kan ikke bruke klasser fra java.util.concurrent-API-
        et, f.eks. Lock og BlockingQueue.

         Tiden det tar å lage og bestille en hamburger skal være (random) mellom 2 og 6 sek.
         */

        // TODO: Correct logic for timeToMakeAndOrder (2000-6000ms)

        final String[] chefs = {"Joachim", "Finn", "Sindre"};
        final String[] waiters = {"Pernille", "Sara"};
        final int capacity = 4;
        final int minimumTimeToMake = 2000, maximumTimeToMake = 6000; // In milliseconds
        TimeUtil timeUtil = new TimeUtil(minimumTimeToMake, maximumTimeToMake);

        //Init print
        System.out.println("[" + timeUtil.currentDateTime() + "] " + "Chefs: " + Arrays.toString(chefs) + "\n"
                            + "[" + timeUtil.currentDateTime() + "] "+ "Waiters: " + Arrays.toString(waiters) + "\n"
                            + "[" + timeUtil.currentDateTime() + "] "+ "Capacity of the hamburgertray: " + capacity);

        // 1 Tray
            /*
              Initialize a hamburgerTray with (capacity)
             */
        HamburgerTray hamburgerTray = new HamburgerTray(capacity);

        // 3 Chefs
        for (String name : chefs) {
            /*
              Start all chef threads
             */
            new Chef(hamburgerTray, name).start();
            System.out.println("[" + timeUtil.currentDateTime() + "] " + "Chef: " + name + " is ready to work");
        }

        // 2 Waiters
        for (String name : waiters) {
            /*
              Start all waiter threads
             */
            new Chef(hamburgerTray, name).start();
            System.out.println("[" + timeUtil.currentDateTime() + "] " + "Waiter: " + name + " is ready to work");
        }

    }
}
