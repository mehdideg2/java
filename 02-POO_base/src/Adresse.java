/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bmarron
 */
public class Adresse {
    String description;
    String rue1;
    String complement;
    String codePostal;
    String ville;

    public Adresse(String rue1, String codePostal, String ville) {
        this.rue1 = rue1;
        this.codePostal = codePostal;
        this.ville = ville;
    }
    
    
}
