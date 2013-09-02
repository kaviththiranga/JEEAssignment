/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.service;

import java.lang.Object;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kavith.jee.assignment.utils.*;

/**
 *
 * @author KavithThiranga
 */
@Stateless
public class AirlineAdminServiceBean implements AirlineAdminServiceBeanRemote {

    static final Logger logger = Logger.getLogger("AirlineAdminServiceBean");
    
    @PersistenceContext
    private EntityManager em;
    
    @EJB private DataQueryServiceLocal dbLocal;
    @EJB private DataQuerySerivceBeanRemote dbRemote;    
    

    @Override
    public void createRecord(RecordDetails obj) {        
        try{
            em.persist((EntityHelper.convertToEntity(obj)));
        }catch(Throwable t){
            logger.log(Level.SEVERE, "Failed to persist entity. Msg {0}", new Object[]{t.getMessage()});
        }
    }

    @Override
    public void updateRecord(RecordDetails obj) {
        try{
            em.merge(EntityHelper.convertToEntity(obj));
        }catch(Throwable t){
            logger.log(Level.SEVERE, "Failed to merge entity. Msg {0}", new Object[]{t.getMessage()});
        }
    }

    @Override
    public void deleteRecord(RecordDetails obj) {
        try{
            em.remove((EntityHelper.convertToEntity(obj)));
        }catch(Throwable t){
            logger.log(Level.SEVERE, "Failed to remove entity. Msg {0}", new Object[]{t.getMessage()});
        }
    } 

    @Override
    public boolean placeABooking(BookingDetails bd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }   
}
