package no.hvl.dat108.ex1.task1;
	public class Main {
	    public static void main(String[] args) {

	            Printer printer = new Printer();
	            Traad traad = new Traad(printer);

	            new Thread(printer).start();
	            new Thread(traad).start();
	        }
	    
	    
}
