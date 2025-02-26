
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Telephones {

    private final Semaphore[] telephones;

    public Telephones(int k) {
		this.telephones = new Semaphore[k];
		for (int i = 0; i < k; i++) {
			this.telephones[i] = new Semaphore(1, true);
		}
    }

    public boolean prendreTelephones(int id, int idTel) {
		try {
			if (this.telephones[idTel].tryAcquire(1, 1, TimeUnit.SECONDS)) {
				System.out.println("Equipe " + id + " a pris le téléphone " + idTel);
				return true;
			} else {
				System.out.println("Equipe " + id + " n'a pas pu prendre le téléphone " + idTel);
				return false;
			}
		} catch (InterruptedException e) {}
		return false;
    }

    public void rendreTelephones(int id, int idTel) {
		this.telephones[idTel].release();
		System.out.println("Equipe " + id + " a rendu le téléphone n°" + idTel);
    }
	public void rendreTelephones(int idTel) {
		this.telephones[idTel].release();
    }

	public int getNbTel() {
		return this.telephones.length;
	}

    public static void main(String[] args) {
		Telephones telephones = new Telephones(2);
		Equipe equipe1 = new Equipe(telephones, 1);
		Equipe equipe2 = new Equipe(telephones, 2);
		Equipe equipe3 = new Equipe(telephones, 3);
		Equipe equipe4 = new Equipe(telephones, 4);
		Equipe equipe5 = new Equipe(telephones, 5);

		equipe1.start();
		equipe2.start();
		equipe3.start();
		equipe4.start();
		equipe5.start();

		try {
			equipe1.join();
			equipe2.join();
			equipe3.join();
			equipe4.join();
			equipe5.join();
		} catch (InterruptedException e) {}
    }
}
