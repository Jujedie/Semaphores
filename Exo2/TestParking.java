import java.util.ArrayList;

public class TestParking {
	private final Parking parking;
	ArrayList<Voiture> lesVoitures;

	public TestParking(int capaciteParking, int nbTotalVoitures) {
		// création du parking et des voitures
		this.parking = new Parking(capaciteParking);
		this.lesVoitures = new ArrayList<>();
		for(int i=0;i<nbTotalVoitures;i++)
			this.lesVoitures.add(new Voiture(parking,i));
		// démarrage des voitures
		for(int i=0;i<nbTotalVoitures;i++)
			this.lesVoitures.get(i).start();
	}

	public static void main(String[] args) {
		new TestParking(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
	}
}
