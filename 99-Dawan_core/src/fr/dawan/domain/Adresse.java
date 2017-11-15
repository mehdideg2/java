package fr.dawan.domain;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bmarron
 */
public class Adresse implements Serializable{
    private String description;
    private String rue1;
    private String complement;
    private String codePostal;
    private String ville;

    public Adresse() {
    }

    public Adresse(String rue1, String codePostal, String ville) {
        this.rue1 = rue1;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRue1() {
        return rue1;
    }

    public void setRue1(String rue1) {
        this.rue1 = rue1;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    
}
