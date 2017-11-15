
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
public class GestionSessions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session sess1 = new Session(new Date());
        
        Stagiaire mehdi = new Stagiaire();
        mehdi.civilite = Genre.MONSIEUR;
        mehdi.prenom = "Mehdi";
        mehdi.niveauProgrammation = Niveau.Intermediaire;
        
        Stagiaire adrian = new Stagiaire("BICKLE", "Adrian", Genre.MONSIEUR);
        adrian.niveauProgrammation = Niveau.Intermediaire;
        
        // Inscrire les stagiaires à la session
        sess1.inscrit(mehdi);
        sess1.inscrit(adrian);
        
        System.out.println("Nb de lieux : "+ Lieu.nbLieux);
        System.out.println("Moyenne des places : "+Lieu.calculeMoyennePlaces());
        Lieu salleLyon1 = new Lieu("Salle 1", 4);
        System.out.println("Nb de lieux : "+ Lieu.nbLieux);
        System.out.println("Moyenne des places : "+Lieu.calculeMoyennePlaces());
        Lieu salleLyon2 = new Lieu("Salle 2", 3);
        System.out.println("Nb de lieux : "+ Lieu.nbLieux);
        System.out.println("Moyenne des places : "+Lieu.calculeMoyennePlaces());
    }
    
}
