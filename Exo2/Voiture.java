public class Voiture extends Thread {
	private final Parking parking;
	private final int id;

	public Voiture(Parking parking, int id) {
		this.parking = parking;
		this.id = id;
	}

	@Override
	public void run() {
		parking.allerAuParking(id);
	}
}
