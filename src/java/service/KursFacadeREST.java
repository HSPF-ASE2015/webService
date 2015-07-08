/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.KursController;
import exceptions.KursException;
import fachklassen.Kurs;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Jeroen
 */
@Stateless
@Path("kursJson")
public class KursFacadeREST{
    @PersistenceContext(unitName = "LearningAgreement_RestfulServicePU")
    private EntityManager em;
    
    @EJB
    KursController kursController;

    public KursFacadeREST() {

    }

    @GET
    @Path("/findAlleKurse")
    @Produces({"application/json"})
    public List<Kurs> findAll() {
        
        List<Kurs> kurse;
        
        try{
            kurse = kursController.findAllKurse();
            return kurse;
            
        } catch(KursException kursException){
            Kurs kursError = new Kurs();
            kursError.setErrorKurs(kursException.getMessage());
            kurse.add(kursError);
            
        } finally{
            return Kurse;
        }
    }  
}
