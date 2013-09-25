/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.service;

import javax.ejb.Local;
import kavith.jee.assignment.entity.Aircraftcb004273;
import kavith.jee.assignment.entity.Bookingcb004273;
import kavith.jee.assignment.entity.Flightcb004273;
import kavith.jee.assignment.entity.Passengercb004273;

/**
 * This is used to expose some methods locally to other ejbs without exposing them in remote interface.
 * @author KavithThiranga
 */
@Local
public interface DataQueryServiceLocal {
    Aircraftcb004273 getAircraftEntityById(String id);
    Flightcb004273 getFlightEntityById(String id);
    Passengercb004273 getPassengerEntityById(String id);
    Bookingcb004273 getBookingEntityById(String id);
    boolean ifSeatsAvailable(String flightID);
}
