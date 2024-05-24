package session.bean;
import entity.compte.Compte;
import jakarta.ejb.Local;

@Local
public interface GestionCompte {

    void ajouter(Compte c);

    Compte consulter(int code);

    void supprimer(int code);

    void verser(int code, double montant);

    void retirer(int code, double montant);
}
