/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.webclient.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import kavith.jee.assignment.service.AirlineAdminServiceBeanRemote;
import kavith.jee.assignment.service.DataQuerySerivceBeanRemote;
import kavith.jee.assignment.utils.BookingDetails;

/**
 *
 * @author KavithThiranga
 */
public class Controller {
    
   @Resource(lookup = "jms/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/FilghtBookingService")
    private Queue queue;
    
    public static AirlineAdminServiceBeanRemote getAirlineAdminServiceBeanRemote() {
        try {
            Context c = new InitialContext();
            return (AirlineAdminServiceBeanRemote) c.lookup("java:global/CB004273_EJBModule/AirlineAdminServiceBean!kavith.jee.assignment.service.AirlineAdminServiceBeanRemote");
        } catch (NamingException ne) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public static DataQuerySerivceBeanRemote getDataQuerySerivceBeanRemote() {
        try {
            Context c = new InitialContext();
            return (DataQuerySerivceBeanRemote) c.lookup("java:global/CB004273_EJBModule/DataQuerySerivceBean!kavith.jee.assignment.service.DataQuerySerivceBeanRemote");
        } catch (NamingException ne) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public void sendBookingRequest(BookingDetails booking){
        Connection connection = null;
        Session session = null;
        MessageProducer messageProducer = null;
        ObjectMessage message = null;

        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageProducer = session.createProducer(queue);
            message = session.createObjectMessage();
            message.setObject(booking);
            messageProducer.send(message);
            

            System.out.println("To see if the bean received the messages,");
            System.out.println(
                    " check <install_dir>/domains/domain1/logs/server.log.");
        } catch (JMSException e) {
            System.out.println("Exception occurred: " + e.toString());

        }

        if (connection != null) {
            try {
                connection.close();
            } catch (JMSException ex) {
            }
        }
    
    }
}
