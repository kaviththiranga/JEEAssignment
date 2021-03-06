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
import sun.awt.windows.ThemeReader;

/**
 *
 * @author Kavith
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "BookingService")
})
public class BookingRequestMDB implements MessageListener {
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
                LOG.log(Level.INFO, "Received booking request with booking number "+bd.getBookingno());
                
                if(dbLocal.ifSeatsAvailable(bd.getFlightId()))
                {
                    em.persist(EntityHelper.convertToEntity(bd));    
                    LOG.log(Level.INFO, "Successfully created booking request with booking number "+bd.getBookingno());
                }else{
                    LOG.log(Level.INFO, "Error placing booking request with booking number "+bd.getBookingno()+". Flight is full.");
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
                LOG.log(Level.WARNING, "Rolled back the booking request with booking number "+bd.getBookingno());
        }
       
    }

}
