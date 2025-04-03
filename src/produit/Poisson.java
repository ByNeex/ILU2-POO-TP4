package produit;
public class Poisson extends Produit{
		private String datePeche;
		
		public Poisson(String datePeche) {
			super();
			this.datePeche = datePeche;
		}

		@Override
		public void decrireProduit() {
			System.out.println(nom + " pêchés " + this.datePeche);
		}
		
}