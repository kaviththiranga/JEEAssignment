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
import kavith.jee.assignment.utils.FlightDetails;
import kavith.jee.assignment.utils.PassengerDetails;

/**
 * This defines data query methods which should be exposed to remote clients.
 * @author KavithThiranga
 */
@Remote
public interface DataQuerySerivceBeanRemote {
    AircraftDetails getAircraftDetailsById(String id);
    FlightDetails getFlightDetailsById(String id);
    PassengerDetails getPassengerDetailsById(String id);
    BookingDetails geBookingDetailsById(String id);
    List<BookingDetails> getBookingsByPassenger(String passengerID);
    List<BookingDetails> getBookingsByFlight(String flightID);    
    Map<String,Short> getAvailableNoOfSeatsInAllFlights();
    List<AircraftDetails> getAllUnallocatedAircrafts();
}
