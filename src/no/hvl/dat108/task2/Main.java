package no.hvl.dat108.task2;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        HamburgerTray hamburgerTray = new HamburgerTray();


        new Thread(new Waiter( hamburgerTray, "Anne")).start();
        new Thread(new Waiter( hamburgerTray, "Bert")).start();
//        new Thread(new Waiter( hamburgerTray, "Cees")).start();

        new Thread(new Chef(hamburgerTray, "Finn")).start();
        new Thread(new Chef(hamburgerTray, "Gert")).start();
        new Thread(new Chef(hamburgerTray, "Hans")).start();
    }
}
