/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dawan.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bmarron
 */
public class ThreadTests extends Thread {

    int pause;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ThreadTests thread1 = new ThreadTests();
            thread1.setName("Omar");
            thread1.pause = 400;
            ThreadTests thread2 = new ThreadTests();
            thread2.setName("Fred");
            thread2.setDaemon(false);
            thread2.pause = 800;
            thread1.start();
            thread2.start();
            System.out.println("Attente d'Omar");
            thread1.join();
            System.out.println("Omar a terminé");
            if (thread2.isAlive()) {
                thread2.interrupt();
                thread2.join();
                System.out.println("Fred a terminé");
            }
            System.out.println("fin du main");
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Execution n°" + i + " de "+ Thread.currentThread().getName());
                Thread.sleep(pause);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadTests.class.getName()).log(Level.SEVERE, "Omar m'a tuer ...", ex);
        }
    }

}
