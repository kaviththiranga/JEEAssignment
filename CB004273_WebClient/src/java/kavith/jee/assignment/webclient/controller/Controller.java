/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.webclient.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public static void sendBookingRequest(BookingDetails booking){
    
    
    }
}
