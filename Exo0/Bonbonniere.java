class Bonbonniere {
	private int nbBonbons ;

	public Bonbonniere(int nbBonbons) {
		 this.nbBonbons = nbBonbons;
	}

	public synchronized int attrapeBonbon() {

		int bonbon = 0 ;

		if ( nbBonbons > 0) {
			bonbon = this.nbBonbons ;
			this.nbBonbons--;
		}

		return bonbon ;
	}

	public static void main(String[] args) {
		Enfant[] lstEnfants = new Enfant[12];

		Bonbonniere b = new Bonbonniere(252);

		for(int i = 0; i < lstEnfants.length; i++){
			lstEnfants[i] = new Enfant(b);
		}

		for(int i = 0; i < lstEnfants.length;i++){
			lstEnfants[i].start();
		}
	}
}