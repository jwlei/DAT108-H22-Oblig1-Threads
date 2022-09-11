package no.hvl.dat108.ex1.task2;
import java.util.Random;

public class Servitor extends Thread {

	private final HamburgerBrett hamburgerbrett;
	private Random random = new Random();
	String name;

	public Servitor(HamburgerBrett hamburgerbrett, String name) {
		this.hamburgerbrett = hamburgerbrett;
		this.setName(name);
}


	@Override
	public void run() {

		while(true) {

			try {
				this.sleep(random.nextInt(4000) + 2000);
				hamburgerbrett.getHamburger();
				
			} catch (InterruptedException x) {
				x.printStackTrace();
				}

			hamburgerbrett.printTrack();
			System.out.println();


	    }
	}
}




