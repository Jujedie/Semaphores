public class Buffer {
	private int nb;
	private int taille;

	public Buffer(int taille) {
		this.taille = taille;
	}

	public synchronized void ajouter() {
		while (this.nb == this.taille) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.nb++;
		notifyAll();
	}

	public synchronized void retirer() {
		while (this.nb == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.nb--;
		notifyAll();
	}

	public String toString(){
		return "------- contenu du buffer : " + this.nb + " / " + this.taille + " -------";
	}
}
