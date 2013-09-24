/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
                
                em.persist(EntityHelper.convertToEntity(bd));
                LOG.log(Level.OFF, "Successfully placed the booking request with booking number "+bd.getBookingno());
               
            }
        } catch (JMSException ex) {
            mdc.setRollbackOnly();
                LOG.log(Level.OFF, "Rolled back the booking request with booking number "+bd.getBookingno());
        }
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
