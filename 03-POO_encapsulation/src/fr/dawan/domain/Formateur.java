package fr.dawan.domain;


import fr.dawan.domain.enums.Genre;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bmarron
 */
public class Formateur {
    private String nom, prenom;
    private Genre civilite;
    private Societe employeur;
    private Formation[] competences;
    private int nbCompetences;

    public Formateur(String nom, String prenom, Genre civilite) {
        this.nom = nom;
        this.prenom = prenom;
        this.civilite = civilite;
        competences = new Formation[20];
    }
    
    public void ajouteCompetence(Formation f) {
        competences[nbCompetences++] = f;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Genre getCivilite() {
        return civilite;
    }

    public void setCivilite(Genre civilite) {
        this.civilite = civilite;
    }

    public Societe getEmployeur() {
        return employeur;
    }

    public void setEmployeur(Societe employeur) {
        this.employeur = employeur;
    }

    public Formation[] getCompetences() {
        return competences;
    }

    public void setCompetences(Formation[] competences) {
        this.competences = competences;
    }
    
    
}
