/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10.entreessorties;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author bmarron
 */
public class EntreesSorties {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file1 = new File("/home/bmarron/formations/javalyon");
        if (file1.exists()) {
            listDir(file1);
        } else {
            if (file1.mkdirs()) {
                System.out.println("création de "+file1);
            } else {
                System.out.println("pb création de "+file1);
            }
        }
        
        File file2 = new File(file1, "test.java");
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            File orig = new File("/home/bmarron/NetBeansProjects/LyonOct2017/10-EntreesSorties/src/pkg10/entreessorties/EntreesSorties.java");
            copy(orig, file2);
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
        
    }

    private static void listDir(File file1) {
        if (file1.isDirectory()) {
            System.out.println("contenu de "+file1);
            for (File f:file1.listFiles()) {
                System.out.println((f.isDirectory()?"<REP>\t":"<FILE>\t")+f.getName());
            }
        }
    }

    private static void copy(File orig, File dest) throws IOException {
        // Lire le fichier origine
        FileReader fr = new FileReader(orig);
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(new FileWriter(dest));
        String line;
        while ((line=br.readLine()) != null) {
            //System.out.println(line);
            bw.write(line);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
    
}
