import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Parking {
	private final Semaphore parking;
	private final Random alea;
	private ArrayList<Integer> voituresEnParking;

	public Parking(int nbPlaces){
		this.alea = new Random(System.currentTimeMillis());
		
		this.parking = new Semaphore(nbPlaces, true);
		this.voituresEnParking = new ArrayList<>();
	}

	public void allerAuParking(int id) {
		System.out.println("Voiture : "+id+" demande à entrer");
		try {
			this.parking.acquire();

			this.voituresEnParking.add(id);
			this.attendre(id);
			this.voituresEnParking.remove((Integer)(id));

			this.parking.release();
		} catch(InterruptedException e) {}
			System.out.println("Voiture : "+id+" sort du parking");
	}

	public void attendre(int id) {
		System.out.println("La voiture : "+id+", "+this.parking.getQueueLength()+" attendent des places dans le parking et "+this.voituresEnParking.size()+" sont garées dont figure :\n"+this.voituresEnParking);
		try {
			Thread.sleep(1000+this.alea.nextInt(1000));
		} catch(InterruptedException ie) {}
	}
}
