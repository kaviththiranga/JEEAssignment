/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cb004273_jeeclientapp;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import kavith.jee.assignment.utils.BookingDetails;

/**
 *
 * @author KavithThiranga
 */
public class Main {
    
    @Resource(mappedName = "java:comp/DefaultJMSConnectionFactory")
    private static ConnectionFactory connectionFactory;

    @Resource(mappedName = "FilghtBookingService")
    private static Topic topic;
    
    public static void main(String[] args) {
        Connection connection = null;
        Session session = null;
        MessageProducer messageProducer = null;
        ObjectMessage message = null;

        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageProducer = session.createProducer(topic);
            message = session.createObjectMessage();
            
            BookingDetails bd = new BookingDetails("B014", "P008", "VR001");
            message.setObject(bd);
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

        System.exit(0);
    }
}
