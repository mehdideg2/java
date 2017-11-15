package fr.dawan.domain;

import fr.dawan.domain.enums.Domaine;
import fr.dawan.domain.enums.Niveau;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bmarron
 */
public class Formation {
    private String titre;
    private int duree;
    private double prixHT;
    private Niveau niveauRequis;
    private Domaine domaine;

    public Formation(String titre, Niveau niveauRequis, Domaine domaine) {
        this.titre = titre;
        this.niveauRequis = niveauRequis;
        this.domaine = domaine;
    }

    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the duree
     */
    public int getDuree() {
        return duree;
    }

    /**
     * @param duree the duree to set
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * @return the prixHT
     */
    public double getPrixHT() {
        return prixHT;
    }

    /**
     * @param prixHT the prixHT to set
     */
    public void setPrixHT(double prixHT) {
        this.prixHT = prixHT;
    }

    /**
     * @return the niveauRequis
     */
    public Niveau getNiveauRequis() {
        return niveauRequis;
    }

    /**
     * @param niveauRequis the niveauRequis to set
     */
    public void setNiveauRequis(Niveau niveauRequis) {
        this.niveauRequis = niveauRequis;
    }

    /**
     * @return the domaine
     */
    public Domaine getDomaine() {
        return domaine;
    }

    /**
     * @param domaine the domaine to set
     */
    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }
    
    
}
