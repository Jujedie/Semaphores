package demo.semaphores;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Magasin {
	
	Semaphore gardien;
	Random alea;
	int nbClientsEnMagasin = 0;
	
	public Magasin(int jauge) {
		alea = new Random(System.currentTimeMillis());
		gardien = new Semaphore(jauge,true); // true: 1er arrivÃ©, 1er servi
	}
	
	public void faireLesCourses(int idfClient) {
		System.out.println("Client : "+idfClient+" demande à entrer");
		try {
			gardien.acquire();
			miseAjourNbClientsPresents(1);
			shopping(idfClient);
			miseAjourNbClientsPresents(-1);
			gardien.release();
		} catch(Exception e) {}
		System.out.println("Client : "+idfClient+" sort du magasin");
	}

	// le shopping dure plus ou moins longtemps
	public void shopping(int idf) {
		System.out.println("le client : "+idf+" fait du shopping "
				+gardien.getQueueLength()+" attendent "+
				nbClientsEnMagasin+" achètent");
		try {
			Thread.sleep(1000+alea.nextInt(1000));
		} catch(InterruptedException ie) {}
	}
	
	public synchronized void miseAjourNbClientsPresents(int i) {
		nbClientsEnMagasin = nbClientsEnMagasin+i;
		
	}
}