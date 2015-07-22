/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andras.szerviz;

import andras.szerviz.entity.Auto;
import andras.szerviz.entity.Ugyfel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Andras
 */
public class Main {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("andras-kovacs-szerviz_andras-szerviz_jar_1.0-SNAPSHOTPU");
    EntityManager em;
    
    public void run() {
        em = emf.createEntityManager();
        try {
           em.getTransaction().begin();
           
           Ugyfel ugyfel = new Ugyfel();
           ugyfel.setNev("Kovács András");
           ugyfel.setTelefon("+3630");
           
           Auto auto = new Auto();
           auto.setRendszam("ABC-422");
           auto.setCcm(1900);
           auto.setMarka("Audi");
           auto.setUgyfel(ugyfel);
           
           em.persist(ugyfel);
           em.persist(auto);  // 
           
           em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public static void main(String[] args) {
        new Main().run();
    }
}
