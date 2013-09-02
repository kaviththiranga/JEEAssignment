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
import kavith.jee.assignment.entity.Flightcb004273;
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
        
        Flightcb004273 flight = dbLocal.getFlightEntityById(bd.getFlightId());
        
        if(flight.getCapacity() > flight.getBookingcb004273List().size())
        {
            try{
                em.persist(EntityHelper.convertToEntity(bd));
                logger.log(Level.INFO, "Booking {0} was placed successfully.", 
                            new Object[]{bd.getBookingno()});
                return true;
            }catch(Throwable t)
            {
                logger.log(Level.INFO, "Error placing the booking {1}. Msg {0}", 
                           new Object[]{t.getMessage(),bd.getBookingno()});
                return false;
            }
        }
        
        logger.log(Level.INFO, "Error placing the booking {0}. Flight is already full.", 
                           new Object[]{bd.getBookingno()});
        
        return false;
    }   
}
