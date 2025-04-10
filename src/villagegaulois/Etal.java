package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;
import produit.Produit;

public class Etal<P extends Produit> implements IEtal<P>{
	private Gaulois vendeur;
	private int quantiteDebutMarche;
	private int quantiteFinMarche;
	private boolean etalOccupe = false;
	private int prix;
	
	// Tableau de produits
	private IProduit[] produits;
	private int nbProduit = 0;

	public boolean isEtalOccupe() {
		return etalOccupe;
	}

	public Gaulois getVendeur() {
		return vendeur;
	}

	public int getQuantite() {
		return quantiteFinMarche;
	}
	
	public void installerVendeur(Gaulois vendeur, IProduit[] produit, int prix) {
		this.vendeur = vendeur;
		this.produits = produit;
		this.nbProduit = produits.length;
		this.prix = prix;
		this.etalOccupe = true;
	}
	
	@Override
	public int contientProduit(String produit, int quantiteSouhaitee) {
		int quantiteAVendre = 0;
		if (nbProduit != 0 && this.produits[0].getNom().equals(produit)) {
			if (nbProduit >= quantiteSouhaitee) {
				quantiteAVendre = quantiteSouhaitee;
			} else {
				quantiteAVendre = nbProduit;
			}
		}
		return quantiteAVendre;
	}
	
	@Override
	public int acheterProduit(int quantiteSouhaite) {
		int prixPaye = 0;
		for(int i = nbProduit - 1; i > nbProduit - quantiteSouhaite - 1 || i > 1; i--) {
			prixPaye += produits[i].calculerPrix(prix);
		}
		if (nbProduit >= quantiteSouhaite) {
			nbProduit -= quantiteSouhaite;
		} else {
			nbProduit = 0;
		}
		return prixPaye;
	}
	
	@Override
	public String etatEtal(){
		StringBuilder chaine = new StringBuilder(vendeur.getNom());
		if (nbProduit > 0){
			chaine.append(" vend ");
			chaine.append(nbProduit + " produits :");
			for (int i = 0; i < nbProduit; i++) {
				chaine.append("\n- " + produits[i].decrireProduit());
			}
		} else {
			chaine.append(" n'a plus rien à vendre.");
		}
		chaine.append("\n");
		return chaine.toString();
	}

}
