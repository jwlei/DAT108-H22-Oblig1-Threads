package no.hvl.dat108.ex1.task2;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {



    HamburgerBrett hamburgerBrett = new HamburgerBrett();

    Kokk kokk1 = new Kokk(hamburgerBrett, "Kokk1");
    Kokk kokk2 = new Kokk(hamburgerBrett, "Kokk2");
    Kokk kokk3 = new Kokk(hamburgerBrett, "Kokk3");
    Servitor serv1 = new Servitor(hamburgerBrett, "Servitor1");
    Servitor serv2 = new Servitor(hamburgerBrett, "Servitor1");

    kokk1.start();
    kokk2.start();
    kokk3.start();
    serv1.start();
    serv2.start();
    
    
    
	}
}
