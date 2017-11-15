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
    
    static int sommePlaces = 0;
    static int nbLieux = 0;
    
    String libelle;
    int nbPlaces;

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
    
}
