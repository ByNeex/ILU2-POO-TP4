package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;

public interface IEtal<P> {
	
	Gaulois getVendeur();
	int contientProduit(String produit, int quantiteSouhaitee);
	int acheterProduit(int quantiteeSouhaitee);
	String etatEtal();
	void installerVendeur(Gaulois vendeur, IProduit[] produit, int prix);
}