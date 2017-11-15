package fr.dawan.main;


import fr.dawan.domain.Formateur;
import fr.dawan.domain.Formation;
import fr.dawan.domain.Lieu;
import fr.dawan.domain.enums.Niveau;
import fr.dawan.domain.Stagiaire;
import fr.dawan.domain.Session;
import fr.dawan.domain.enums.Domaine;
import fr.dawan.domain.enums.Genre;
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
        
        System.out.println("Nb de lieux : "+ Lieu.nbLieux);
        System.out.println("Moyenne des places : "+Lieu.calculeMoyennePlaces());
        Lieu salleLyon1 = new Lieu("Salle 1", 4);
        Formateur benjamin = new Formateur("MARRON", "Benjamin", Genre.MONSIEUR);
        
        Formation java5j = new Formation("Java Initiation & Approfondissement", Niveau.Debutant, Domaine.Dev);
        java5j.setDuree(5);
        Session sess1 = new Session(new Date(), salleLyon1, java5j);
        sess1.setFormateurAffecte(benjamin);
        
        Stagiaire mehdi = new Stagiaire();
        mehdi.setCivilite(Genre.MONSIEUR);
        mehdi.setPrenom("Mehdi");
        mehdi.setNiveauProgrammation(Niveau.Intermediaire);
        
        Stagiaire adrian = new Stagiaire("BICKLE", "Adrian", Genre.MONSIEUR);
        adrian.setNiveauProgrammation(Niveau.Intermediaire);
        
        // Inscrire les stagiaires à la session
        System.out.println("Inscription Mehdi 1: "+sess1.inscrit(mehdi));
        System.out.println("Inscription Adrian 2: "+sess1.inscrit(adrian));
        System.out.println("Inscription Mehdi 3: "+sess1.inscrit(mehdi));
        System.out.println("Inscription Adrian 4: "+sess1.inscrit(adrian));
        boolean inscriptionOK = sess1.inscrit(mehdi);
        System.out.println("Inscription Mehdi 5: "+inscriptionOK);
        if (!inscriptionOK) {
            System.out.println("Changement de salle");
            Lieu salle8places = new Lieu("grande salle Lyon", 8);
            sess1.setSalleDeFormation(salle8places);
            inscriptionOK = sess1.inscrit(mehdi);
            System.out.println("Inscription Mehdi 5: "+inscriptionOK);
        }
        System.out.println("Inscription Adrian 6: "+sess1.inscrit(adrian));
        
        System.out.println("=====================================");
        System.out.println("Récapitulatif de la session");
        System.out.println("=====================================");
        System.out.println("Titre : "+sess1.getFormationDispensee().getTitre());
        System.out.println("Durée : "+sess1.getFormationDispensee().getDuree());
        System.out.println("Formateur : "+sess1.getFormateurAffecte().getPrenom());
        System.out.println("Lieu : "+sess1.getSalleDeFormation().getLibelle());
        System.out.println("=====================================");
        System.out.println("Liste des inscrits : "+sess1.getNbInscrits());
        for (Stagiaire s:sess1.getInscrits()) {
            if (s != null) {
                System.out.println("Stagiaire "+ s.getCivilite()+" "+s.getPrenom());
                System.out.println("Niveau "+ s.getNiveauProgrammation());
                System.out.println("-----");
            }
            
        }
        
    }
    
}
