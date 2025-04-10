package produit;

public abstract class Produit implements IProduit {
	protected String nom;
	protected Unite unite;
	
	@Override
	public String getNom() {
		return nom;
	}
	
	@Override
	public int calculerPrix(int prix) {
		// Comportement par défaut : on retourne simplement le prix
		return prix;
	}

}
