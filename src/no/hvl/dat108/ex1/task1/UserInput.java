package no.hvl.dat108.ex1.task1;

import java.util.Objects;

import static javax.swing.JOptionPane.showInputDialog;

public class UserInput implements Runnable {


    Printer printer;

    public UserInput(Printer printer) {
        this.printer = printer;
    }

    private void input() {
        String textToChange;

        do {
            textToChange = showInputDialog("skriv inn tekst eller quit for å avslutte");
            printer.setMessage(textToChange);

        } while (!Objects.equals(textToChange, "quit"));
        printer.quit();

    }



    @Override
    public void run() {
        input();

    }
}
