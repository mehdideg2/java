package fr.dawan.domain;


import java.util.Arrays;
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
public class Session {
    private Date dateDebut;
    private Lieu salleDeFormation;
    private Formation formationDispensee;
    private Formateur formateurAffecte;
    private Stagiaire[] inscrits;
    private int nbInscrits;

    public Session(Date dateDebut, Lieu salle, Formation formation) {
        this.dateDebut = dateDebut;
        salleDeFormation = salle;
        formationDispensee = formation;
        inscrits = new Stagiaire[salle.getNbPlaces()];
    }
    
    public boolean inscrit(Stagiaire s) {
        // Regle de gestion 1 : verifier niveau requis
        if (s.getNiveauProgrammation().compareTo(formationDispensee.getNiveauRequis()) < 0) {
            return false;
        }
        // Regle de gestion 2 : places disponibles
        if (nbInscrits < salleDeFormation.getNbPlaces()) {
            inscrits[nbInscrits++] = s;
            return true;
        } else {
            return false;
        }
        
    }
    
    public PersonnePhysique[] getParticipants() {
        PersonnePhysique[] resultat;
        resultat = new PersonnePhysique[nbInscrits+1];
        resultat[0] = formateurAffecte;
        for (int i = 0; i < nbInscrits; i++) {
            resultat[i+1] = inscrits[i];
        }
        return resultat;
    }

    /**
     * @return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return the salleDeFormation
     */
    public Lieu getSalleDeFormation() {
        return salleDeFormation;
    }

    /**
     * @param salleDeFormation the salleDeFormation to set
     */
    public void setSalleDeFormation(Lieu salleDeFormation) {
        this.salleDeFormation = salleDeFormation;
        inscrits = Arrays.copyOf(inscrits, salleDeFormation.getNbPlaces());
        
    }

    /**
     * @return the formationDispensee
     */
    public Formation getFormationDispensee() {
        return formationDispensee;
    }

    /**
     * @param formationDispensee the formationDispensee to set
     */
    public void setFormationDispensee(Formation formationDispensee) {
        this.formationDispensee = formationDispensee;
    }

    /**
     * @return the formateurAffecte
     */
    public Formateur getFormateurAffecte() {
        return formateurAffecte;
    }

    /**
     * @param formateurAffecte the formateurAffecte to set
     */
    public void setFormateurAffecte(Formateur formateurAffecte) {
        this.formateurAffecte = formateurAffecte;
        formateurAffecte.ajouteCompetence(formationDispensee);
    }

    /**
     * @return the inscrits
     */
    public Stagiaire[] getInscrits() {
        return inscrits;
    }

    /**
     * @param inscrits the inscrits to set
     */
    public void setInscrits(Stagiaire[] inscrits) {
        this.inscrits = inscrits;
    }

    public int getNbInscrits() {
        return nbInscrits;
    }
}
