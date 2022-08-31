package no.hvl.dat108.ex1.task2;

import no.hvl.dat108.ex1.task2.models.Chef;
import no.hvl.dat108.ex1.task2.models.HamburgerTray;
import no.hvl.dat108.ex1.task2.models.Waiter;
import no.hvl.dat108.ex1.task2.utility.TimeUtil;

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

        TODO: Done
        Krav til programmet
         Både Hamburger, HamburgerBrett, Kokk og Servitor skal være klasser i programmet
        slik det er naturlig. Kokker og servitører er tråder, mens brettet er en delt ressurs
        som både kokker og servitører forholder seg til.

        TODO: Done
        * De ulike objektene i programmet skal samarbeide via referanser til hverandre, ikke
        gjennom globale variabler.

        TODO: Done?
        * Programmet må være trådsikkert slik at det ikke blir rot i tellingen og i køen av
        hamburgere. Kokker og servitører må vente hvis det er nødvendig, ikke bare kjøre
        videre.

        TODO: Done
        * Hvis brettet er tomt, må servitører vente til det er lagt en ny hamburger på, og hvis
        brettet er fullt, må kokker vente til det er tatt en hamburger av.

        TODO: Done-ish
        * Det er meningen at dere skal bruke tråd-primitivene synchronized, wait, notify og
        notifyAll til å løse oppgaven. Dere kan ikke bruke klasser fra java.util.concurrent-API-
        et, f.eks. Lock og BlockingQueue.

        TODO: Correct logic for timeToMakeAndOrder (2000-6000ms per hamburger)
        * Tiden det tar å lage og bestille en hamburger skal være (random) mellom 2 og 6 sek.
         */

        final String[] chefs = {"Joachim", "Finn", "Sindre"};
        final String[] waiters = {"Pernille", "Sara"};
        final int capacity = 4;
        final int minimumTimeToMake = 2000, maximumTimeToMake = 6000; // In milliseconds

        TimeUtil timeUtil = new TimeUtil(minimumTimeToMake, maximumTimeToMake);

        //Init print
        System.out.println(timeUtil.currentTimeStamp() + Arrays.toString(chefs) + "\n"
                            + timeUtil.currentTimeStamp() + Arrays.toString(waiters) + "\n"
                            + timeUtil.currentTimeStamp() + "Capacity of the hamburger tray is: " + (capacity) + " hamburgers\n"
                            + " --- --- --- --- --- --- --- --- --- --- ");

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
            String role = "[Chef] ";
            name = role+=name;
            new Chef(hamburgerTray, name, timeUtil).start();
            System.out.println(timeUtil.currentTimeStamp() + name + " is ready to work");
        }

        // 2 Waiters
        for (String name : waiters) {
            /*
              Start all waiter threads
             */
            String role = "[Waiter] ";
            name = role+=name;
            new Waiter(hamburgerTray, name, timeUtil).start();
            System.out.println(timeUtil.currentTimeStamp() + name + " is ready to work");
        }

        System.out.println(" --- --- --- --- --- --- --- --- --- --- ");

    }
}
