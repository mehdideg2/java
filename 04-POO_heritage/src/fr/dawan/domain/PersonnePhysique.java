/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dawan.domain;

import fr.dawan.domain.enums.Genre;

/**
 *
 * @author bmarron
 */
public class PersonnePhysique {
    public static final String CONSTANTE = "constante";
    
    private String nom;
    protected String prenom;
    private Genre civilite;
    private Societe employeur;

    public PersonnePhysique() {
    }

    public PersonnePhysique(String nom, String prenom, Genre civilite) {
        this.nom = nom;
        this.prenom = prenom;
        this.civilite = civilite;
    }
    
    public boolean isSalarie() {
        return employeur != null;
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
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the civilite
     */
    public Genre getCivilite() {
        return civilite;
    }

    /**
     * @param civilite the civilite to set
     */
    public void setCivilite(Genre civilite) {
        this.civilite = civilite;
    }

    /**
     * @return the employeur
     */
    public Societe getEmployeur() {
        return employeur;
    }

    /**
     * @param employeur the employeur to set
     */
    public void setEmployeur(Societe employeur) {
        this.employeur = employeur;
    }

    @Override
    public String toString() {
        return "nom=" + nom + ", prenom=" + prenom + ", civilite=" + civilite + ", employeur=" + employeur;
    }

}
