
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bmarron
 */
public class Menu {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String saisie;
        int[] mesDonnees = null;
        // Débit de boucle
        do {
            System.out.println("=== Gestion d'un tableau d'entiers ===");
            System.out.println("1) Saisie");
            System.out.println("2) Affichage");
            System.out.println("3) Calcul (min, max, moyenne)");
            System.out.println("9) Quitter");

            saisie = sc.next();

            /* if (saisie.equals("9")) {
                System.out.println("Au revoir !");
                break;
            } */
            switch (saisie) {
                case "1":
                    System.out.println("Saisie du tableau");
                    mesDonnees = saisie(sc);
                    break;
                case "2":
                    System.out.println("Affichage du tableau");
                    affiche(mesDonnees);

                    break;
                case "3":
                    System.out.println("Valeurs particulières du tableau");
                    System.out.println("Minimum : "+minimum(mesDonnees));
                    System.out.println("Maximum : "+maximum(mesDonnees));
                    System.out.println("Moyenne : "+moyenne(mesDonnees));
                    
                    break;
                case "9":
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix possibles : 1, 2, 3 ou 9");
                    break;
            }
            // Fin de boucle

        } while (!saisie.equals("9"));
        boolean maCondition = true;
        System.out.println(maCondition ? "Condition vraie" : "Condition fausse");

        sc.close();
    }

    private static int[] saisie(Scanner sc) throws NumberFormatException {
        // Demander le nb d'éléments
        System.out.print("Nb d'items du tableau : ");
        String nbStr = sc.next();
        int nbItems = Integer.parseInt(nbStr);
        // Créer le tableau
        int[] resultat = new int[nbItems];
        // Saisir chaque élément du tableau
        for (int i = 0; i < resultat.length; i++) {
            System.out.print("Item[" + i + "]=");
            int data = sc.nextInt();
            resultat[i] = data;
        }
        return resultat;
    }

    private static void affiche(int[] mesDonnees) {
        if (mesDonnees != null) {
            // Parcourir le tableau pour afficher les éléments
            for (int i = 0; i < mesDonnees.length; i++) {
                System.out.println("Item[" + i + "]=" + mesDonnees[i]);
            }
            /* for (int item : mesDonnees) {
            System.out.println(item);
            } */
        } else {
            System.out.println("Le tableau n'est pas initialisé.");
        }
    }

    private static int minimum(int[] mesDonnees) {
        int minimum=mesDonnees[0];
        for (int i = 1; i < mesDonnees.length; i++) {
            if (mesDonnees[i] < minimum) {
                minimum = mesDonnees[i];
            }
        }
        return minimum;
    }

    private static int maximum(int[] mesDonnees) {
        int maximum = Arrays.stream(mesDonnees).max().getAsInt();
        
        return maximum;
    }

    private static double moyenne(int[] mesDonnees) {
        double moyenne = 0;
        for (int item:mesDonnees) {
            moyenne += item;
        }
        return moyenne/mesDonnees.length;
    }
}
