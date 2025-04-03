package villagegaulois;

import personnages.Gaulois;
import produit.Produit;

public class Etal <P extends Produit> {
	private Gaulois vendeur;
	private P produit;
	private int quantiteDebutMarche;
	private int quantite;
	private boolean etalOccupe = false;

	public boolean isEtalOccupe() {
		return etalOccupe;
	}

	public Gaulois getVendeur() {
		return vendeur;
	}

	public int getQuantite() {
		return quantite;
	}

	public P getProduit() {
		return produit;
	}

	public void occuperEtal(Gaulois vendeur, P produit, int quantite) {
		this.vendeur = vendeur;
		this.produit = produit;
		this.quantite = quantite;
		quantiteDebutMarche = quantite;
		etalOccupe = true;
	}

	public boolean contientProduit(String produit) {
		return this.produit.equals(produit);
	}

	public int acheterProduit(int quantiteAcheter) {
		if (quantite == 0) {
			quantiteAcheter = 0;
		}
		if (quantiteAcheter > quantite) {
			quantiteAcheter = quantite;
		}
		if (etalOccupe) {
			quantite -= quantiteAcheter;
		}
		return quantiteAcheter;
	}

	public void libererEtal() {
		etalOccupe = false;
	}

	
	public String[] etatEtal() {
		String[] donneesVente = new String[5];
		donneesVente[0] = String.valueOf(etalOccupe);
		if (etalOccupe) {
			donneesVente[1] = vendeur.getNom();
			donneesVente[2] = produit.getNom();
			donneesVente[3] = String.valueOf(quantiteDebutMarche);
			donneesVente[4] = String.valueOf(quantiteDebutMarche - quantite);
		}
		return donneesVente;
	}

}
