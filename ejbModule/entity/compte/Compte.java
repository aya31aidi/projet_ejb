package entity.compte;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "COMPTE_TABLE")
public class Compte implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code; // Clé primaire générée automatiquement

    private double prix;
    private String dateCreation;

    // Constructeur par défaut requis par JPA
    public Compte() {
    }

    // Constructeur avec paramètres
    public Compte(int code ,double prix, String dateCreation) {
    	this.code = code;
    	this.prix = prix;
        this.dateCreation = dateCreation;
    }

    // Getters et setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}
