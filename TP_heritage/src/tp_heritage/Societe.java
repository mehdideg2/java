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
public class Societe extends AbstractSociete{
    int nbEmployes;
    
    @Override
    public int calculChiffreAffaire() {
        return 1000 * nbEmployes;
    }
    
    
}
