package fr.dawan.domain;

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
    private String nom;
    private String SIRET;
    private Adresse adresse;

    public Societe(String nom) {
        this.nom = nom;
    }

    public Societe(String nom, String SIRET) {
        this(nom);
        this.SIRET = SIRET;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the SIRET
     */
    public String getSIRET() {
        return SIRET;
    }

    /**
     * @param SIRET the SIRET to set
     */
    public void setSIRET(String SIRET) {
        this.SIRET = SIRET;
    }

    /**
     * @return the adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Societe{" + "nom=" + nom + ", SIRET=" + SIRET + ", adresse=" + adresse + '}';
    }
    
    
}
