public class Lanceur {
	private Buffer buf;
	private ProdConso[] prodconsos;

	public static void main(String[] args) {
		new Lanceur(12);	
	}

	public Lanceur(int nbProdConso) {
		this.buf = new Buffer(150);
		this.prodconsos = new ProdConso[nbProdConso];
		for(int i = 0; i < nbProdConso; i++){
			this.prodconsos[i] = new ProdConso(i,this.buf,5);
			this.prodconsos[i].start();
		}
	}
}