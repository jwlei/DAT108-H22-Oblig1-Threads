package no.hvl.dat108.ex1.task3;

public class Hamburger {
	
	private int nummer;
	private static int burgerNummer = 0;
	private int id;
	
	Hamburger() {
		this.nummer = (int)(Math.random() * 3);
		id = ++burgerNummer;
	}
	
	Hamburger(int nummer) {
		this.nummer = nummer;
	}
	
	public int getNummer() {
		return nummer;
	}
	
	public int getId() {
		return id;
	}
	
	public String getType() {
		if (nummer == 0) {
			return "Vanlig Hamburger";
		}
		if (nummer == 1) {
			return "Hamburger med ost";
		}
		if (nummer == 2) {
			return "Hamburger med ost og Bacon";
			
		}
		
		else return "super Burger";
	}
    @Override
    public String toString() {
        return ("[" + id + "]" + this.getType());
    }
}
	