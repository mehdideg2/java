package fr.dawan.main;


import fr.dawan.domain.Formateur;
import fr.dawan.domain.Formation;
import fr.dawan.domain.Lieu;
import fr.dawan.domain.PersonnePhysique;
import fr.dawan.domain.enums.Niveau;
import fr.dawan.domain.Stagiaire;
import fr.dawan.domain.Session;
import fr.dawan.domain.Societe;
import fr.dawan.domain.enums.Domaine;
import fr.dawan.domain.enums.Genre;
import fr.dawan.domain.enums.PriseEnCharge;
import fr.dawan.domain.exceptions.LevelException;
import fr.dawan.domain.exceptions.TooManyItemsException;
import java.util.Calendar;
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
        
        Societe dawan = new Societe("DAWAN");
        benjamin.setEmployeur(dawan);
        Societe yumi = new Societe("YUMI");
        Societe mlp = new Societe("Messageries Lyonnaises de Presse");
        
        Formation java5j = new Formation("Java Initiation & Approfondissement", Niveau.Debutant, Domaine.Dev);
        java5j.setDuree(5);
        java5j.setPrixHT(2375);
        Date dateDebut = new Date();
        Calendar cal = Calendar.getInstance();
        cal.set(2017, Calendar.OCTOBER, 16);
        cal.set(Calendar.MONTH, Calendar.OCTOBER);
        //cal.add(Calendar.DAY_OF_MONTH, 16);
        dateDebut = cal.getTime();
        Session sess1 = new Session(dateDebut, salleLyon1, java5j);
        sess1.setFormateurAffecte(benjamin);
        
        Stagiaire mehdi = new Stagiaire();
        mehdi.setCivilite(Genre.MONSIEUR);
        mehdi.setPrenom("Mehdi");
        mehdi.setNom("DEGHDACHE");
        mehdi.setEmployeur(yumi);
        mehdi.setPayeur(PriseEnCharge.Employeur);
        mehdi.setNiveauProgrammation(Niveau.Intermediaire);
        
        Stagiaire adrian = new Stagiaire("BICKLE", "Adrian", Genre.MONSIEUR);
        adrian.setEmployeur(yumi);
        adrian.setPayeur(PriseEnCharge.Individuel);
        adrian.setNiveauProgrammation(Niveau.Intermediaire);
        
        // Inscrire les stagiaires à la session
        try {
            sess1.inscrit(mehdi);
            sess1.inscrit(adrian);
            sess1.inscrit(adrian);
        } catch (LevelException e) {
            System.out.println(e.getCurrent());
        } catch (TooManyItemsException e) {
            e.printStackTrace();
        }
        
        System.out.println("=====================================");
        System.out.println("Récapitulatif de la session");
        System.out.println("=====================================");
        System.out.println("Titre : "+sess1.getFormationDispensee().getTitre());
        System.out.println("Durée : "+sess1.getFormationDispensee().getDuree());
        System.out.println("Formateur : "+sess1.getFormateurAffecte().getPrenom());
        System.out.println("Salarie : "+ sess1.getFormateurAffecte().isSalarie());
        System.out.println("Lieu : "+sess1.getSalleDeFormation().getLibelle());
        System.out.println("=====================================");
        System.out.println("Liste des inscrits : "+sess1.getNbInscrits());
        for (Stagiaire s:sess1.getInscrits()) {
            if (s != null) {
                //System.out.println("Stagiaire "+ s.getCivilite()+" "+s.getPrenom());
                //System.out.println("Niveau "+ s.getNiveauProgrammation());
                //System.out.println("Salarie "+ s.isSalarie());
                System.out.println(s);
                System.out.println("-----");
            }
            
        }
        
        System.out.println("=====================================");
        System.out.println("Liste des participants : ");
        for (PersonnePhysique pp:sess1.getParticipants()) {
            if (pp != null) {
                System.out.println(pp.carteDeVisite());
            }
        }
        System.out.println("=====================================");
        System.out.println("Montant TTC de la session : "+sess1.calculMontantTTC());
        //mehdi.setPayeur(PriseEnCharge.Pole_Emploi);
        System.out.println("Montant TTC de la session : "+sess1.calculMontantTTC());
        sess1.setRemise(0.2);
        System.out.println("Montant TTC de la session : "+sess1.calculMontantTTC());
    }
    
}
