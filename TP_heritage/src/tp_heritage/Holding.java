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
public class Holding extends AbstractSociete {
    AbstractSociete[] filiales = new AbstractSociete[10];
    int nbFiliales = 0;

    @Override
    public int calculChiffreAffaire() {
        int CA = 0;
        for (AbstractSociete s : filiales) {
            if (s != null) {
                CA += s.calculChiffreAffaire();
            }
            
        }
        return CA;
    }
    
    
}
