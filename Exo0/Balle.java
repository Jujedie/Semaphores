import java.util.Random;

public class Balle {
	private boolean encours = true;
	private int joueurencours = 0;
	private Random alea;
	private int echange = 0;

	public Balle(){
		alea = new Random(System.currentTimeMillis());
		if(!alea.nextBoolean()){
			this.joueurencours = 1;
		}
		System.out.println("engagement pour le joueur " + this.joueurencours);
	}
	public synchronized boolean tape(int idJoueur){
		while(idJoueur != joueurencours){try{wait();}catch(InterruptedException e){}}
		if(encours){
			if(alea.nextInt(100) > 20){
				System.out.println("Joueur " + joueurencours + " a tapé la balle");
				this.echange++;
			} else {
				this.encours = false;
				System.out.println("Joueur " + joueurencours + " a raté la balle");
				System.out.println("longueur de l'échange : " + this.echange);
			}
		}
		this.joueurencours = (this.joueurencours + 1) % 2;
		notify();
		return encours;
	}
}