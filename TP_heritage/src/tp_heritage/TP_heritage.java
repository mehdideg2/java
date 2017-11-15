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
public class TP_heritage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Societe s1 = new Societe();
        s1.nbEmployes = 15;
        s1.nom = "SARL";
        
        System.out.println("Chiffre affaire SARL "+s1.calculChiffreAffaire());
        
        Holding h1 = new Holding();
        h1.nom = "World company";
        h1.filiales[h1.nbFiliales++] = s1;
        System.out.println("Chiffre affaire holding "+h1.calculChiffreAffaire());
        
        Societe s2 = new Societe();
        s2.nbEmployes = 12;
        s2.nom = "SA Yumi";
        
        
        Holding h2 = new Holding();
        h2.nom = "World Company France";
        h2.filiales[h2.nbFiliales++] = s2;
        h1.filiales[h1.nbFiliales++] = h2;
        System.out.println("Chiffre affaire holding "+h1.calculChiffreAffaire());
       
    }
    
}
