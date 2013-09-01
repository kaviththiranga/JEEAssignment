/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.service;

import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import kavith.jee.assignment.utils.AircraftDetails;
import kavith.jee.assignment.utils.BookingDetails;
import kavith.jee.assignment.utils.RecordDetails;

/**
 *
 * @author KavithThiranga
 */
@Stateless(mappedName = "AirlineAdminService")
public class AirlineAdminServiceBean implements AirlineAdminServiceBeanRemote {

    @Override
    public void createRecord(RecordDetails obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateRecord(RecordDetails obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteRecord(RecordDetails obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<BookingDetails> getBookingsByPassenger(String passengerID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<BookingDetails> getBookingsByFlight(String flightID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean placeABooking(BookingDetails bd) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Map<String, Integer> getAvailableNoOfSeatsInAllFlights() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<AircraftDetails> getAllUnallocatedAircrafts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}
