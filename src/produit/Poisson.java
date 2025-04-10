package produit;
public class Poisson extends Produit{
		private String datePeche;
		
		public Poisson(String datePeche) {
			super();
			this.datePeche = datePeche;
			this.nom = "poisson";
			this.unite = Unite.piece;
		}

		@Override
		public String decrireProduit() {
			return(nom + " pêché " + this.datePeche + ".");
		}
		
}