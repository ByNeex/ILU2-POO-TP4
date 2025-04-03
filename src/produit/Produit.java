package produit;

public abstract class Produit {
	protected String nom;
	protected Unite unite;
	
	public String getNom() {
		return nom;
	}
	
	public abstract void decrireProduit();
	
	

}
