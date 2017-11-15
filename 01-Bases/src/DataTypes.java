/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bmarron
 */
public class DataTypes {
     public static void main(String args[]) {
        System.out.println("=== Types de données ===");
        
        int monEntier;
        monEntier = 15;
        short monCourt = 65;
        
        System.out.println(monEntier);
        System.out.println(monCourt);
        
        boolean monBoolean = false, monAutreBoolean;
        System.out.println(monBoolean);
        
        char monCaractere = 'v';
        double monDouble = 54.258;
        System.out.println(monDouble);
        
        //float monFlottant = (float)15.2;
        float monFlottant = 15.2f;
        
        long monLong = 999999999999999L;
        
        monDouble = monFlottant;
        System.out.println(monDouble); // ?? 15.2
        
        monEntier = 54;
        monDouble = monEntier;
        System.out.println(monDouble); // ?? 54.0
        
        monDouble = 14.99;
        monEntier = (int)monDouble;
        System.out.println(monEntier); // 14 
        
        monEntier = (int)monLong;
        System.out.println(monEntier); // ??
        
        monEntier = 0x16;
        System.out.println(monEntier); // 22
        
        monEntier = 0xFF;
        System.out.println(monEntier); // 255
        
        monEntier = 057;
        System.out.println(monEntier); // 47
        
        // Wrappers
        System.out.println("== Wrappers ==");
        
        Integer monInteger = null;
        // impossible sur type primitif : monEntier = null;
        System.out.println(monInteger);
        // Autoboxing
        monInteger = new Integer(15);
        monInteger = 15;
        
        monEntier = monInteger.intValue();
        monEntier = monInteger;
        
        monFlottant = monInteger;
        
        System.out.println(monInteger);
        System.out.println(monEntier);
        System.out.println(monFlottant);
        
        // Opérateurs affectations
        int monCompteur = 0;
        System.out.println(monCompteur); // 0
        monCompteur = monCompteur + 1; 
        System.out.println(monCompteur); // 1
        monCompteur += 1; // monCompteur = monCompteur + 1
        System.out.println(monCompteur); // 2
        monCompteur *= 6;
        System.out.println(monCompteur); // 12
        
        // Opérateurs incréments
        monCompteur++;
        System.out.println(monCompteur); // 13
        System.out.println(monCompteur++); // 14
        System.out.println(monCompteur); // 14
        System.out.println(++monCompteur); // 15
        
        // Opérateurs binaires
        monCompteur = monCompteur << 1;
        System.out.println(monCompteur); // 30
        monCompteur = monCompteur | 1;
        System.out.println(monCompteur); // 31
        monCompteur = monCompteur & 1;
        System.out.println(monCompteur); // 1
        monCompteur = monCompteur ^ 1;
        System.out.println(monCompteur); // 0
   }
}
