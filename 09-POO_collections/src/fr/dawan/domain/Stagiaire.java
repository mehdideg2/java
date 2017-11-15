package fr.dawan.domain;


import fr.dawan.domain.enums.Niveau;
import fr.dawan.domain.enums.Genre;
import fr.dawan.domain.enums.PriseEnCharge;
import fr.dawan.domain.interfaces.Remisable;
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
public class Stagiaire extends PersonnePhysique implements Remisable{
    private Date dateNaissance;
    private Niveau niveauProgrammation;
    private PriseEnCharge payeur;
    
    public Stagiaire() {
    }
    
    public Stagiaire(String nom, String prenom) {
        this(nom, prenom, Genre.AUTRE);
    }
    
    public Stagiaire(String nom, String prenom, Genre civilite) {
        super(nom, prenom, civilite);
    }

    @Override
    public boolean isSalarie() {
        return super.isSalarie() && payeur.equals(PriseEnCharge.Employeur);
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

    @Override
    public String toString() {
        return "Stagiaire{"+super.toString() + ", dateNaissance=" + dateNaissance + ", niveauProgrammation=" + niveauProgrammation + ", payeur=" + payeur + '}';
    }

    @Override
    public String carteDeVisite() {
        return getCivilite()+ " " + getPrenom() + " " + getNom() + " " + getEmployeur().getNom()+ ", dateNaissance=" + dateNaissance + ", niveauProgrammation=" + niveauProgrammation + ", payeur=" + payeur;    
    }

    @Override
    public double getTauxRemise() {
        if (payeur == PriseEnCharge.Pole_Emploi) {
            return 0.2;
        } 
        return 0;
    }

}
