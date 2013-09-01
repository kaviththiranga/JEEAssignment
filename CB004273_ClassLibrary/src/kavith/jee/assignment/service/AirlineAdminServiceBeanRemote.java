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

/**
 *
 * @author KavithThiranga
 */
@Remote
public interface AirlineAdminServiceBeanRemote {
    void createRecord(Object obj);
    void updateRecord(Object obj);
    void deleteRecord(Object obj);
    List<BookingDetails> getBookingsByPassenger(String passengerID);
    List<BookingDetails> getBookingsByFlight(String flightID);
    boolean placeABooking(BookingDetails bd);
    Map<String,Integer> getAvailableNoOfSeatsInAllFlights();
    List<AircraftDetails> getAllUnallocatedAircrafts();   
}
