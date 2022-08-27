package no.hvl.dat108.ex1.task1;

import java.sql.Time;

public class Main {
    public static void main(String[] args) {
        /**
         * Initialize a printer and InputDialog.
         * Start a separate thread for each.
         */
        Printer printer = new Printer();
        InputDialog inputDialog = new InputDialog(printer);

        new Thread(printer).start();
        new Thread(inputDialog).start();
    }
}

