package produit;

import personnages.Gaulois;

public class Sanglier extends Produit{
		private int poids;
		private Gaulois chasseur;
		
		public Sanglier(int poids, Gaulois chasseur) {
			super();
			this.poids = poids;
			this.chasseur = chasseur;
			this.nom = "sanglier";
			this.unite = Unite.kg;
		}



		@Override
		public String decrireProduit() {
			return (nom + " de " + poids + " " + unite + " chassé par " + chasseur.getNom());
		}
		
}