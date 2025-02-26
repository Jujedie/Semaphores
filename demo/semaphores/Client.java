package demo.semaphores;


public class Client extends Thread {

	Magasin shop;
	int id;
	int nbVisites = 1;
	
	public Client(Magasin shop, int id) {
		this.shop = shop;
		this.id = id;
	}
	
	public void run() {
		for(int i=0;i<nbVisites;i++) {
			shop.faireLesCourses(id);
		}
	}
	
}
