package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegaulois.IVillage;

public class Scenario {
	

	public static void main(String[] args) {

		// TODO Partie 4 : creer de la classe anonyme Village
		IVillage village = new IVillage() {

            // Le marché contient plusieurs étals
            private Etal<?>[] marche = new Etal[3]; // Utilisation du wildcard pour accepter tous les types d'étals
            private int nbEtals = 0;

            @Override
            public <P extends Produit> boolean installerVendeur(IEtal<P> etal, Gaulois vendeur, P[] produits, int prix) {
                etal.installerVendeur(vendeur, produits, prix);
                marche[nbEtals++] = (Etal<?>) etal;
                return true;
            }

            @Override
            public void acheterProduit(String produit, int quantiteSouhaitee) {
                int quantiteRestante = quantiteSouhaitee;
                for (int i = 0; i < nbEtals && quantiteRestante > 0; i++) {
                    Etal<?> etal = marche[i];  // Utilisation du wildcard
                    int quantiteDisponible = etal.contientProduit(produit, quantiteRestante);
                    if (quantiteDisponible > 0) {
                        int prix = etal.acheterProduit(quantiteDisponible);
                        String nomProduit = accorderNomProduit(produit, quantiteDisponible);
                        System.out.println("A l'étal n° " + (i + 1) + ", j'achète " + quantiteDisponible + " " + nomProduit + " et je paye " + prix + " sous.");
                        quantiteRestante -= quantiteDisponible;
                    }
                }
                String nomProduit = accorderNomProduit(produit, quantiteSouhaitee);
                System.out.println("Je voulais " + quantiteSouhaitee + " " + nomProduit + ", j'en ai acheté " + (quantiteSouhaitee - quantiteRestante) + ".\n");
            }

            private String accorderNomProduit(String produit, int quantite) {
                return quantite > 1 ? produit + "s" : produit;
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < nbEtals; i++) {
                    Etal<?> etal = marche[i];
                    if (etal != null && etal.getVendeur() != null) {
                        sb.append(etal.etatEtal()).append("\n");
                    }
                }
                return sb.toString();
            }
        };

		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		IEtal<Sanglier> etalSanglierObelix = new Etal<>();
		IEtal<Sanglier> etalSanglierAsterix = new Etal<>();
		IEtal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		village.acheterProduit("sanglier", 3);

		System.out.println(village);
	}

}
