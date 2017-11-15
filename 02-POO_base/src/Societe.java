/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bmarron
 */
public class Societe {
    String nom, SIRET;

    public Societe(String nom) {
        this.nom = nom;
    }

    public Societe(String nom, String SIRET) {
        this(nom);
        this.SIRET = SIRET;
    }
    
    
}
