package no.hvl.dat108.ex1.task1;

public class Printer implements Runnable {
	
	private boolean kjører = true;
	private String melding = "Hallo verden!";
	
	@Override
	public void run() {
		
		printMelding();
	}
	
	private void printMelding() {
		while (kjører) {
			System.out.println(melding);
			synchronized (this) {
				try {
					wait(3000); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("quitted");
	}
	
	
	public synchronized void quit() {
		kjører = false;
		notify();
	}
	
	public void setMelding(String melding) {
		this.melding = melding;
	}

}
