/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.KursController;
import exceptions.KursException;
import fachklassen.Kurs;
import java.util.ArrayList;
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
 * 
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
    public List<KursWS> findAll() {

        List<Kurs> kurse = new ArrayList<>();
        List<KursWS> kurseWS = new ArrayList<>();

        try {
            kurse = kursController.findAllKurse();

        } catch (KursException kursException) {
            KursWS kursWSError = new KursWS();
            kursWSError.setErrorKurs(kursException.getMessage());
            kurseWS.add(kursWSError);
            
            return kurseWS;
        }

        for (Kurs kurs : kurse) {
            
            KursWS kursWS = new KursWS();

            kursWS.setEcts(kurs.getEcts());
            kursWS.setName(kurs.getName());
            kursWS.setSprache(kurs.getSprache());
            kursWS.setHochschule(kurs.getHochschule());

            kurseWS.add(kursWS);
        }

        return kurseWS;
    }  
}
