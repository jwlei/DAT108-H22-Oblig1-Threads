package no.hvl.dat108.task1;

public class Printer implements Runnable {

    private String message = "Hei Verden!";
    boolean isPrinting = true;


    @Override
    public void run() {

        try {
            printing();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void quit() {
        isPrinting = false;
    }

    private void printing() throws InterruptedException {
        while (isPrinting) {
            System.out.println(message);
               Thread.sleep(3000);
        }
        System.out.println("exit");
    }
}



