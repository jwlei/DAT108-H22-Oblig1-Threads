package no.hvl.dat108.ex1.task1;

import no.hvl.dat108.ex1.task1.TimeUtil;
public class Printer implements Runnable {

    private boolean isRunning = true;
    private TimeUtil timeUtil = new TimeUtil();
    private String message = "I'm the default LOOPING message ... ";


    @Override
    public void run() {
        printMessage();
    }

    private void printMessage() {
        /**
         * Method for printing a message.
         */
        while (isRunning) {

            System.out.println("[" + timeUtil.currentDateTime() + "] " + message);
            synchronized (this) {
                try {
                    wait(3000);
                    /**
                     * Wakes up when notified by the Quit function.
                     */
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Printer has exited and ended.");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public synchronized void quit() {
        isRunning = false;
        /**
         * Notifies the thread that has a lock on this object
         */
        notify();
    }


}
