/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_heritage;

/**
 *
 * @author bmarron
 */
public abstract class Constructeur{ 
    
    public void construitMaison() {
        // Construit les murs
        construitMurs();
        // Poser la charpente
        poseCharpente();
        // Installer electricite
        installationElectricite();
        
    }
    
    public void construitMurs() {
        System.out.println("maconnerie");

    }

    private void poseCharpente() {
        System.out.println("charpente");

    }

    public abstract void installationElectricite();
}
