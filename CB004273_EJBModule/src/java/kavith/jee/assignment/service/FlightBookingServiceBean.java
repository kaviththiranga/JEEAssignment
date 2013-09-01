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

/**
 *
 * @author KavithThiranga
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "FilghtBookingService"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "durable"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "FilghtBookingService"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "FilghtBookingService")
})
public class FlightBookingServiceBean implements MessageListener {
   
    static final Logger logger = Logger.getLogger("BookingServiceBean");
    
    @Resource
    private MessageDrivenContext mdc;
    
    @PersistenceContext
    private EntityManager em;

    
    public FlightBookingServiceBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        BookingDetails booking;
        ObjectMessage msg = null;

        try {
            if (message instanceof ObjectMessage) {
                msg = (ObjectMessage) message;
                booking = (BookingDetails)msg.getObject();
                logger.log(
                        Level.INFO, "Booking request received. ID :{0} Flight ID:{1}", 
                        new Object[]{ booking.getBookingno(),
                        booking.getFlight().getFlightno()}
                        );
                // TODO: call service bean and make the booking
            }
         }catch (JMSException e) {
            mdc.setRollbackOnly();
        } catch (Throwable te) {
        }         
    }
}
