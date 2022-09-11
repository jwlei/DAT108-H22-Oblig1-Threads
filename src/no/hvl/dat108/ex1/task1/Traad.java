package no.hvl.dat108.ex1.task1;

import static javax.swing.JOptionPane.showInputDialog;

public class Traad implements Runnable {
	
private final Printer printer;

public Traad(Printer printer) {
	this.printer = printer;
		
	    }

@Override
public void run() {
	String Traad = "skiver en melding som blir loopet, avslutt ved å skrive quit";
	String input;

	while ((input = showInputDialog(Traad)) != null && !input.equalsIgnoreCase("quit")) {
		printer.setMelding(input);
	}
	System.out.println("Shutting down...");
	printer.quit();

	}
}


