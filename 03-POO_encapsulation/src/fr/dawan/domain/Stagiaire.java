package fr.dawan.domain;


import fr.dawan.domain.enums.Niveau;
import fr.dawan.domain.enums.Genre;
import fr.dawan.domain.enums.PriseEnCharge;
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
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Niveau niveauProgrammation;
    private Genre civilite;
    //java.sql.Date sqlDate;
    private Societe employeur;
    private PriseEnCharge payeur;
    
    public Stagiaire() {
        //sqlDate = new java.sql.Date(0);
    }
    
    public Stagiaire(String nom, String prenom) {
        this(nom, prenom, Genre.AUTRE);
    }
    
    public Stagiaire(String nom, String prenom, Genre civilite) {
        this.nom = nom;
        this.prenom = prenom;
        this.civilite = civilite;
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
     * @return the dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * @return the niveauProgrammation
     */
    public Niveau getNiveauProgrammation() {
        return niveauProgrammation;
    }

    /**
     * @param niveauProgrammation the niveauProgrammation to set
     */
    public void setNiveauProgrammation(Niveau niveauProgrammation) {
        this.niveauProgrammation = niveauProgrammation;
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

    /**
     * @return the payeur
     */
    public PriseEnCharge getPayeur() {
        return payeur;
    }

    /**
     * @param payeur the payeur to set
     */
    public void setPayeur(PriseEnCharge payeur) {
        this.payeur = payeur;
    }
}
