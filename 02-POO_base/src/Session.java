
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bmarron
 */
public class Session {
    Date dateDebut;

    public Session(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    
    boolean inscrit(Stagiaire s) {
        return false;
    }
}
