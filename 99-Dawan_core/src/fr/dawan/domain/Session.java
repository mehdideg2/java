package fr.dawan.domain;


import fr.dawan.domain.exceptions.LevelException;
import fr.dawan.domain.exceptions.TooManyItemsException;
import fr.dawan.domain.interfaces.Facturable;
import fr.dawan.domain.interfaces.Remisable;
import java.io.Serializable;
import java.util.ArrayList;
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
public class Session extends DbEntity implements Facturable, Remisable, Serializable{
    private Date dateDebut;
    private Lieu salleDeFormation;
    private Formation formationDispensee;
    private Formateur formateurAffecte;
    private ArrayList<Stagiaire> inscrits;
    private double remise;

    public Session() {
    }

    /**
     * Constructeur 
     * @param dateDebut
     * @param salle
     * @param formation 
     */
    public Session(Date dateDebut, Lieu salle, Formation formation) {
        this.dateDebut = dateDebut;
        salleDeFormation = salle;
        formationDispensee = formation;
        inscrits = new ArrayList<>();
    }
    
    /**
     * Inscrit un stagiaire dans une session
     * @param s le stagiaire a inscrire
     * @throws LevelException si le niveau du stagiaire est inferieur au niveau requis
     * @throws TooManyItemsException si le lieu associé à la session est complet
     */
    public void inscrit(Stagiaire s) throws LevelException, TooManyItemsException  {
        // Regle de gestion 1 : verifier niveau requis
        if (s.getNiveauProgrammation().compareTo(formationDispensee.getNiveauRequis()) < 0) {
            throw new LevelException("Niveau incorrect"
                    , s.getNiveauProgrammation()
                    , formationDispensee.getNiveauRequis());
        }
        // Regle de gestion 2 : places disponibles
        if (inscrits.size() < salleDeFormation.getNbPlaces()) {
            inscrits.add(s);
        } else {
            throw new TooManyItemsException("Trop de stagiaires");
        }
        
    }
    
    /**
     * Retourne la liste des personnes présentes à la session, stagiaire et formateur
     * @return la liste des personnes présentes
     */
    public ArrayList<PersonnePhysique> getParticipants() {
        ArrayList<PersonnePhysique> resultat;
        resultat = new ArrayList<>(inscrits);
        resultat.add(formateurAffecte);
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
    public ArrayList<Stagiaire> getInscrits() {
        return inscrits;
    }

    /**
     * @param inscrits the inscrits to set
     */
    public void setInscrits(ArrayList<Stagiaire> inscrits) {
        this.inscrits = inscrits;
    }

    public int getNbInscrits() {
        return inscrits.size();
    }

    @Override
    public double calculMontantTTC() {
        double montantTotal = 0;
        double montantFormation = formationDispensee.calculMontantTTC();
        for (Stagiaire inscrit : inscrits) {
            if (inscrit != null) {
                double montantApresRemise = montantFormation * (1-inscrit.getTauxRemise());
                montantTotal += montantApresRemise;
            }
        }
        double montantSessionApresRemise = montantTotal * (1-getTauxRemise());
        return montantSessionApresRemise;
        //return nbInscrits * formationDispensee.calculMontantTTC();
    }

    @Override
    public double getTauxRemise() {
        
        // Regle de gestion 1 : plus de 3 stagiaires
        if (inscrits.size() >= 3) {
            Societe employeur = inscrits.get(0).getEmployeur();
            if (employeur != null) {
                boolean memeEmployeur = false;
                for (Stagiaire s:inscrits) {
                    if (employeur.equals(s.getEmployeur())) {
                        memeEmployeur = true;
                    } else {
                        memeEmployeur = false;
                        break;
                    }
                }
                if (memeEmployeur) {
                    return Math.max(remise, 0.1);
                }
                
            }
        }
        return remise;
    }
    
    public void setRemise(double remise) {
        this.remise = remise;
    }
}
