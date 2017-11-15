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
public class Formateur extends PersonnePhysique{
    
    private Formation[] competences;
    private int nbCompetences;

    public Formateur(String nom, String prenom, Genre civilite) {
        super(nom, prenom, civilite);
        competences = new Formation[20];
    }
    
    public void ajouteCompetence(Formation f) {
        competences[nbCompetences++] = f;
    }

    public Formation[] getCompetences() {
        return competences;
    }

    public void setCompetences(Formation[] competences) {
        this.competences = competences;
    }

    @Override
    public String carteDeVisite() {
        return getCivilite()+ " " + getPrenom() + " " + getNom() + " " + getEmployeur().getNom();
    }
    
    
}
