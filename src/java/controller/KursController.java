/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptions.KursException;
import fachklassen.Kurs;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jeroen
 */
@Stateless
public class KursController {
    
    @PersistenceContext
    private EntityManager em;
    
    
    public KursController(){ 
    }
    
    private void initialize() {
        try {
            Kurs englisch = new Kurs(6, "Englisch", "english");
            Kurs programmieren = new Kurs(9, "Programmieren", "english");
            Kurs debating = new Kurs(3, "Debating", "english");
            
            em.persist(englisch);
            em.persist(programmieren);
            em.persist(debating);

        } catch (Exception ex) {
            Logger.getLogger(KursController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public List<Kurs> findAllKurse() throws KursException{
       initialize();
        
       try {
            return em.createNamedQuery("getAllKurse").getResultList();  
        
       } catch (Exception ex) {
            throw new KursException(ex.getMessage());
       }
    }   
}
