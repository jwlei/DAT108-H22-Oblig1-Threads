package no.hvl.dat108.task3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class HamburgerTray {

    private final int maxLength = 4;
    private BlockingQueue<Hamburger> hamburgerTray = new ArrayBlockingQueue<>(maxLength);


    public void addBurger(Hamburger hamburger) throws InterruptedException {

        if (isFull()) {
            System.out.println("HamburgerTray is full, waiting");
        } else {
            hamburgerTray.add(hamburger);
            System.out.println(Thread.currentThread().getName() + " put " + hamburger.toString() + " on the tray: " + hamburgerTray);
        }
    }

    public Hamburger takeBurger() throws InterruptedException {
        if (hamburgerTray.isEmpty()) {
            System.out.println("HamburgerTray is empty, waiting");
        } else {
            Hamburger burger = hamburgerTray.take();
            System.out.println(Thread.currentThread().getName() + " took " + burger.toString() + " from the tray: " + hamburgerTray);
            return burger;
        }
        return null;
    }

//    public boolean isEmpty() {
//        return hamburgerTray.size() == 0;
//    }

    public boolean isFull() {
        return hamburgerTray.size() == maxLength;
    }
}
