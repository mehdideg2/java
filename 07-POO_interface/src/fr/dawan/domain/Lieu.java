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
public class Lieu {
    
    public static int sommePlaces = 0;
    public static int nbLieux = 0;
    
    private String libelle;
    private int nbPlaces;
    private Adresse adresse;

    public Lieu(String libelle, int nbPlaces) {
        this.libelle = libelle;
        this.nbPlaces = nbPlaces;
        nbLieux++;
        sommePlaces += nbPlaces;
    }
    
    public static double calculeMoyennePlaces() {
        if (nbLieux == 0) {
            return 0;
        }
        return (double)sommePlaces/nbLieux;
    }

    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * @return the nbPlaces
     */
    public int getNbPlaces() {
        return nbPlaces;
    }

    /**
     * @param nbPlaces the nbPlaces to set
     */
    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
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
    
}
