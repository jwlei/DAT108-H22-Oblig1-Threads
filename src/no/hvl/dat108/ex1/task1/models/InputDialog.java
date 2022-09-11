package no.hvl.dat108.ex1.task1.models;

import static javax.swing.JOptionPane.showInputDialog;

public class InputDialog implements Runnable {

    private final Printer printer;

    public InputDialog(Printer printer) {
        this.printer = printer;
    }

    /**
     * Simple run method to be called when initializing the class in a thread from Main.
     */
    @Override
    public void run() {
        String inputDialogMsg = "Input a message to be LOOPED. Press cancel/input 'quit' to quit.";
        String input;

        /**
         * While input isn't null, print the message.
         * If the message is 'quit', exit the thread.
         */
        while ((input = showInputDialog(inputDialogMsg)) != null
                && !input.equalsIgnoreCase("quit")) {
            printer.setMessage(input);
        }
        System.out.println("Shutting down...");
        printer.quit();
    }
}
