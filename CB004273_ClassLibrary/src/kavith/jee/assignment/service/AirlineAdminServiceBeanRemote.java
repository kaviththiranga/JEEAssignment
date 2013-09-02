/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.service;

import java.util.List;
import java.util.Map;
import javax.ejb.Remote;
import kavith.jee.assignment.utils.AircraftDetails;
import kavith.jee.assignment.utils.BookingDetails;
import kavith.jee.assignment.utils.RecordDetails;

/**
 *
 * @author KavithThiranga
 */
@Remote
public interface AirlineAdminServiceBeanRemote {
    void createRecord(RecordDetails obj);
    void updateRecord(RecordDetails obj);
    void deleteRecord(RecordDetails obj);    
    boolean placeABooking(BookingDetails bd);   
}
