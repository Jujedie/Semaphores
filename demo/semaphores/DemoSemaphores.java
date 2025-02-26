package demo.semaphores;

import java.util.ArrayList;

public class DemoSemaphores {

	Magasin shop;
	ArrayList<Client> lesClients;
	
	public DemoSemaphores(int capaciteMagasin, int nbTotalClients) {
		// crÃ©ation du magasin et des clients
		shop = new Magasin(capaciteMagasin);
		lesClients = new ArrayList<>();
		for(int i=0;i<nbTotalClients;i++)
			lesClients.add(new Client(shop,i));
		// dÃ©marrage des clients
		for(int i=0;i<nbTotalClients;i++)
			lesClients.get(i).start();
	}
	
	
	public static void main(String[] args) {
		new DemoSemaphores(2,6);
	}

}