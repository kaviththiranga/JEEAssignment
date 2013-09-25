/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kavith.jee.assignment.entity.Flightcb004273;
import kavith.jee.assignment.utils.BookingDetails;
import kavith.jee.assignment.utils.EntityHelper;

/**
 *
 * @author Kavith
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "FilghtBookingService")
})
public class BookingRequestMDB implements MessageListener {
    @EJB
    private DataQuerySerivceBeanRemote dbRemote;
    @EJB
    private DataQueryServiceLocal dbLocal;    
    
    @PersistenceContext(unitName = "CB004273_EJBModulePU")
    private EntityManager em;
    
    @Resource
    private MessageDrivenContext mdc;
    
    private static final Logger LOG = Logger.getLogger(BookingRequestMDB.class.getName());
    
    
    
    public BookingRequestMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        BookingDetails bd = null;
        try {
            if (message instanceof ObjectMessage) {
                bd = (BookingDetails)((ObjectMessage)message).getObject();
                Flightcb004273 flight = dbLocal.getFlightEntityById(bd.getFlightId());
                if(flight.getCapacity() > dbRemote.getBookingsByFlight(bd.getFlightId()).size())
                {
                    em.persist(EntityHelper.convertToEntity(bd));    
                    LOG.log(Level.OFF, "Successfully created booking request with booking number "+bd.getBookingno());
                }else{
                    LOG.log(Level.OFF, "Error placing booking request with booking number "+bd.getBookingno()+". Flight is full.");
                }
            }
        } catch (JMSException ex) {
           
        }
        catch (Exception ex){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex1) {
                Logger.getLogger(BookingRequestMDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
             mdc.setRollbackOnly();
                LOG.log(Level.OFF, "Rolled back the booking request with booking number "+bd.getBookingno());
        }
       
    }

}
