
import java.util.ArrayList;

public class Equipe extends Thread {
	private final Telephones telephones;
	private final int id;
	private int nbTel;

    public Equipe(Telephones telephones, int id) {
		this.telephones = telephones;
		this.id = id;	
		this.nbTel = 0;
    }

    @Override
    public void run() {
		// Prendre un téléphone au hasard
		ArrayList<Integer> telPris = new ArrayList<>();

		int idTel = (int) (Math.random() * telephones.getNbTel());
		if (this.telephones.prendreTelephones(this.id, idTel)){
			telPris.add(idTel);
			this.nbTel++;
		}


		while(nbTel < 2){
			while (telPris.contains(idTel)){
				idTel = (int) (Math.random() * telephones.getNbTel());
			}

			if (this.telephones.prendreTelephones(this.id, idTel)){
				telPris.add(idTel);
				this.nbTel++;
			} else {
				this.telephones.rendreTelephones(this.id,idTel);
				this.nbTel--;
				telPris.remove((Integer)(idTel));
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {}
		}

		for (int idTelPris : telPris){
			this.telephones.rendreTelephones(idTelPris);
		}

		System.out.println("Equipe " + this.id + " a fini");
    }
}