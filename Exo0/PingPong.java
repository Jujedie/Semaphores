public class PingPong {
	private Joueur j1, j0;

	public static void main(String[] args) {
		new PingPong();	
	}

	public PingPong() {
		Balle balle = new Balle();
		Joueur j0 = new Joueur(0, balle);
		Joueur j1 = new Joueur(1, balle);
		j0.start();
		j1.start();
	}
	
}
