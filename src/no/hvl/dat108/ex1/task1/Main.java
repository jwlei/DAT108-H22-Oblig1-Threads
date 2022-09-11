package no.hvl.dat108.ex1.task1;

import no.hvl.dat108.ex1.task1.models.InputDialog;
import no.hvl.dat108.ex1.task1.models.Printer;

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

