
public class Enfant extends Thread {
	private static int idGeneral = 0;

	private int 		id;
	private int 		nb;
	private Bonbonniere bonbonniere;

    public Enfant(Bonbonniere bonbonniere) {
		this.id = Enfant.idGeneral++;
		this.nb = 0;
		this.bonbonniere = bonbonniere;
	}

	public void run() {
        int bonbon = bonbonniere.attrapeBonbon();
        while (bonbon != 0) {
            System.out.println("enfant :" + id + " bonbon : " + bonbon);
			try {Thread.sleep(1000);} catch (InterruptedException e) {} // Avec ce code tous les enfants ont environs le même nombre de bonbons
            bonbon = bonbonniere.attrapeBonbon();
            nb++;
        }
        System.out.println("numero "+this.id+" - nb bonbons mangés : " + nb);
    }
}
