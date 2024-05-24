package session.bean;

import entity.compte.Compte;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

@Stateless
public class GestionCompteBean implements GestionCompte {

    @PersistenceContext(unitName = "CompteEntity")
    private EntityManager entityManager;

    public GestionCompteBean() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CompteEntity");
        entityManager = emf.createEntityManager();
    }

    @Override
    public void ajouter(Compte c) {
        if (entityManager != null) {
            entityManager.getTransaction().begin();
            entityManager.persist(c);
            entityManager.getTransaction().commit();
        } else {
            throw new IllegalStateException("EntityManager n'est pas correctement initialisé.");
        }
    }

    @Override
    public Compte consulter(int code) {
        return entityManager.find(Compte.class, code);
    }

    @Override
    public void supprimer(int code) {
        Compte compte = entityManager.find(Compte.class, code);
        if (compte != null) {
            entityManager.remove(compte);
        }
    }

    @Override
    public void verser(int code, double montant) {
        Compte compte = entityManager.find(Compte.class, code);
        if (compte != null) {
            compte.setPrix(compte.getPrix() + montant);
            entityManager.merge(compte);
        }
    }

    @Override
    public void retirer(int code, double montant) {
        Compte compte = entityManager.find(Compte.class, code);
        if (compte != null && compte.getPrix() >= montant) {
            compte.setPrix(compte.getPrix() - montant);
            entityManager.merge(compte);
        }
    }
}
