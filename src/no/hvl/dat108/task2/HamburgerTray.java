package no.hvl.dat108.task2;

import java.util.ArrayDeque;
import java.util.Queue;


public class HamburgerTray {

    private final int maxLength = 4;
    private Queue<Hamburger> hamburgerTray = new ArrayDeque<>();


    public synchronized void addBurger(Hamburger hamburger) throws InterruptedException {

        while (isFull()) {
            System.out.println("HamburgerTray is full, waiting");
            wait();
        }

        hamburgerTray.add(hamburger);
        System.out.println(Thread.currentThread().getName() + " put " + hamburger.toString() + " on the tray: " + hamburgerTray);
        notifyAll();
    }

    public synchronized Hamburger takeBurger() throws InterruptedException {
        while (isEmpty()) {
            System.out.println("HamburgerTray is empty, waiting");
            wait();
        }
        Hamburger burger = hamburgerTray.poll();
        System.out.println(Thread.currentThread().getName() + " took " + burger + " from the tray: " + hamburgerTray);
        notifyAll();
        return burger;
    }

    public boolean isEmpty() {
        return hamburgerTray.size() == 0;
    }

    public boolean isFull() {
        return hamburgerTray.size() == maxLength;
    }
}
