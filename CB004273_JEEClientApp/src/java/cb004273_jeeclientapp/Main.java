/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cb004273_jeeclientapp;

import javax.annotation.Resource;
import javax.ejb.EJB;
import kavith.jee.assignment.service.AirlineAdminServiceBeanRemote;
import kavith.jee.assignment.utils.AircraftDetails;

/**
 *
 * @author KavithThiranga
 */
public class Main {
    @EJB
    private static AirlineAdminServiceBeanRemote airlineAdminServiceBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       AircraftDetails ac = new AircraftDetails("001", "New", "detals", new Short("150"));
       airlineAdminServiceBean.createRecord(ac);
       
    }
}
