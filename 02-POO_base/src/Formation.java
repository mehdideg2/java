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
    String titre;
    int duree;
    double prixHT;
    Niveau niveauRequis;
    Domaine domaine;

    public Formation(String titre, Niveau niveauRequis, Domaine domaine) {
        this.titre = titre;
        this.niveauRequis = niveauRequis;
        this.domaine = domaine;
    }
    
    
}
