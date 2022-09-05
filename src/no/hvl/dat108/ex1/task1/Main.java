package no.hvl.dat108.ex1.task1;

public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer();
        UserInput userInput = new UserInput(printer);


        new Thread(printer).start();
        new Thread(userInput).start();

        // missing way to exit

    }
}
