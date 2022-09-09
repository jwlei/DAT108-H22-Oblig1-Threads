package no.hvl.dat108.ex1.task3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Servitor extends Thread {

    private final BlockingQueue<Hamburger> bq;
	private Random random = new Random();
	String name;

	public Servitor(BlockingQueue<Hamburger> bq, String name) {
        this.bq = bq;
        this.setName(name);

    }


	@Override
	public void run() {

		while(true) {

			try {
				Thread.sleep(random.nextInt(2000) + 4000);
				if(bq.isEmpty()) {
					System.out.print(this.getName() + " venter på å hente, men brettet er tomt. VENTER! \n");
				}
				Hamburger hentetHamburger = bq.take();
                System.out.print(this.getName() + " henter [" + hentetHamburger.getId() + "]" + hentetHamburger.getType() + " <= " + bq + "\n");
				
			} catch (InterruptedException x) {
				x.printStackTrace();
				}

	
	    }
	}
}




