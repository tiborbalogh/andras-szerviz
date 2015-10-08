/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andras.szerviz;

import andras.szerviz.beans.AuthenticationFacadeRemote;
import andras.szerviz.beans.AutoFacadeRemote;
import andras.szerviz.beans.UgyfelFacadeRemote;
import andras.szerviz.entity.AuthenticationData;
import andras.szerviz.entity.Auto;
import andras.szerviz.entity.Dolgozo;
import andras.szerviz.entity.Ugyfel;
import andras.szerviz.form.Login;
import andras.szerviz.form.LoginDialog;
import andras.szerviz.form.Ugyfelszolg;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Andras
 */
public class Main implements Runnable {
    
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            /* for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            } */
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ugyfelszolg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ugyfelszolg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ugyfelszolg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ugyfelszolg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Main());
    }
    
    @Override
    public void run() {
        try {
            AuthenticationFacadeRemote auth = ClientUtil.getAuthenticationFacade();
            LoginDialog login = new LoginDialog(null, true);
            login.setVisible(true);
            while (login.isSubmitted()) {
                AuthenticationData authData = login.getAuthenticationData();
                
                Dolgozo dolgozo = auth.login(authData);
                if (dolgozo != null) {
                    Ugyfelszolg ugyfelszolg = new Ugyfelszolg();
                    ugyfelszolg.setVisible(true);
                } 
                login.setVisible(true);
            }
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void run_old() {
        
        try {
            UgyfelFacadeRemote ugyfelFacade = ClientUtil.getUgyfelFacade();
            AutoFacadeRemote autoFacade = ClientUtil.getAutoFacade();
            
            
         // Felvitel:   
            Ugyfel ugyfel = new Ugyfel();
            ugyfel.setNev("Kovács András");
            ugyfel.setCim("Veszprém");
            ugyfel.setTelefon("+3630");
            ugyfel.setEmail("andras@sdgsd" + ((long)(Math.random() * 100000)));
            
            System.out.println("Ügyfél létrehozása....");
            ugyfelFacade.create(ugyfel);
            System.out.println("Ügyfél létrehozva");
            
            Auto auto = new Auto();
            auto.setRendszam("ABC-422");
            auto.setCcm(1900);
            // auto.setMarka("Audi");
            auto.setUgyfel(ugyfel);
            
            System.out.println("Autó létrehozása....");
            autoFacade.create(auto);
            System.out.println("Autó létrehozva");
            
         // Lekérdezés:
            List<Ugyfel> ugyfelek = ugyfelFacade.findAll();
            for (Ugyfel u: ugyfelek) {
                System.out.println("Ügyfél: " + u);
            }
            
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }

   
    
    
}
