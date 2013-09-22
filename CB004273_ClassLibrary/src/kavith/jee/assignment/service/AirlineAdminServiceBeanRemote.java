/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.service;

import javax.ejb.Remote;
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
    String placeABooking(BookingDetails bd);   
}
