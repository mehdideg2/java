package fr.dawan.domain;


import fr.dawan.domain.enums.Genre;
import java.util.HashSet;

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
    
    private HashSet<Formation> competences;

    public Formateur(String nom, String prenom, Genre civilite) {
        super(nom, prenom, civilite);
        competences = new HashSet<>();
    }
    
    public void ajouteCompetence(Formation f) {
        competences.add(f);
    }

    public HashSet<Formation> getCompetences() {
        return competences;
    }

    public void setCompetences(HashSet<Formation> competences) {
        this.competences = competences;
    }

    @Override
    public String carteDeVisite() {
        return getCivilite()+ " " + getPrenom() + " " + getNom() + " " + getEmployeur().getNom();
    }
    
    
}
