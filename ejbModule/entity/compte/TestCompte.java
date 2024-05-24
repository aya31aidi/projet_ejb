package entity.compte;
import session.bean.GestionCompteBean;

public class TestCompte {

    public static void main(String[] args) {
        // Création manuelle de GestionCompteBean
        GestionCompteBean gestionCompte = new GestionCompteBean();

        // Ajout des comptes
        ajouterComptes(gestionCompte);

        // Versement de 100.000 dans le compte numéro 2
        versement(gestionCompte, 2, 100000);

        // Consultation du compte numéro 2
        consulterCompte(gestionCompte, 2);

        // Retrait de 50.000 du compte numéro 3
        retrait(gestionCompte, 3, 50000);

        // Tentative de consultation d'un compte inexistant
        consulterCompte(gestionCompte, 5);

        // Tentative de suppression d'un compte inexistant
        supprimerCompte(gestionCompte, 5);

        // Tentative de retrait d'un montant supérieur au solde du compte
        retrait(gestionCompte, 1, 2000);
    }

    private static void ajouterComptes(GestionCompteBean gestionCompte) {
        gestionCompte.ajouter(new Compte(1, 1205.260, "04/01/2017"));
        gestionCompte.ajouter(new Compte(2, 50.300, "04/01/2017"));
        gestionCompte.ajouter(new Compte(3, 100.000, "04/01/2017"));
    }

    private static void versement(GestionCompteBean gestionCompte, int codeCompte, double montant) {
        gestionCompte.verser(codeCompte, montant);
        System.out.println("Versement effectué avec succès sur le compte numéro " + codeCompte);
    }

    private static void consulterCompte(GestionCompteBean gestionCompte, int codeCompte) {
        try {
            Compte compte = gestionCompte.consulter(codeCompte);
            System.out.println("Consultation du compte numéro " + codeCompte + " : " + compte);
        } catch (RuntimeException e) {
            System.out.println("Erreur lors de la consultation du compte numéro " + codeCompte + " : " + e.getMessage());
        }
    }

    private static void retrait(GestionCompteBean gestionCompte, int codeCompte, double montant) {
        try {
            gestionCompte.retirer(codeCompte, montant);
            System.out.println("Retrait de " + montant + " effectué avec succès sur le compte numéro " + codeCompte);
        } catch (RuntimeException e) {
            System.out.println("Erreur lors du retrait sur le compte numéro " + codeCompte + " : " + e.getMessage());
        }
    }

    private static void supprimerCompte(GestionCompteBean gestionCompte, int codeCompte) {
        try {
            gestionCompte.supprimer(codeCompte);
            System.out.println("Suppression du compte numéro " + codeCompte + " effectuée avec succès");
        } catch (RuntimeException e) {
            System.out.println("Erreur lors de la suppression du compte numéro " + codeCompte + " : " + e.getMessage());
        }
    }
}
