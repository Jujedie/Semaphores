import java.util.Random;

public class Joueur extends Thread {
	private int id;
	private int score = 0;
	Random alea;
	Balle balle;

	public Joueur(int id, Balle balle) {
		this.id = id;
		this.balle = balle;
	}

	public void run(){
		while(this.balle.tape(this.id)){
			this.score++;
		}
		System.out.println("Joueur " + this.id +" a terminé après "+ this.score + " échanges");
	}
}
