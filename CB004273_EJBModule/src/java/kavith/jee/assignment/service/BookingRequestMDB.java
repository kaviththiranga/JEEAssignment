/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kavith.jee.assignment.utils.BookingDetails;

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
    private AirlineAdminServiceBeanRemote airlineAdminServiceBean;
 
    public BookingRequestMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                BookingDetails bd = (BookingDetails)((ObjectMessage)message).getObject();
                airlineAdminServiceBean.placeABooking(bd);
            }
        } catch (JMSException ex) {
            Logger.getLogger(BookingRequestMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
