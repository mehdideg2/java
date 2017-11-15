
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bmarron
 */
public class Stagiaire {
    String nom, prenom;
    Date dateNaissance;
    Niveau niveauProgrammation;
    Genre civilite;
    
    public Stagiaire() {
        
    }
    
    public Stagiaire(String nom, String prenom) {
        this(nom, prenom, Genre.AUTRE);
    }
    
    public Stagiaire(String nom, String prenom, Genre civilite) {
        this.nom = nom;
        this.prenom = prenom;
        this.civilite = civilite;
    }
}
