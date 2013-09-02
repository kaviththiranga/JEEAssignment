/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kavith.jee.assignment.utils.*;
import kavith.jee.assignment.entity.*;


/**
 *
 * @author KavithThiranga
 */
@Stateless(mappedName = "DataQuerySerivce")
public class DataQuerySerivceBean implements DataQuerySerivceBeanRemote,DataQueryServiceLocal {

    @PersistenceContext
    private EntityManager em;
    
    public Aircraftcb004273 getAircraftEntityById(String id){
        return em.find(Aircraftcb004273.class, id);
    }

    @Override
    public AircraftDetails getAircraftDetailsById(String id) {
        return (AircraftDetails)EntityHelper.convertToDetails(getAircraftEntityById(id));
    }
    
    public Flightcb004273 getFlightEntityById(String id)
    {
        return em.find(Flightcb004273.class, id);
    }

    @Override
    public FlightDetails getFlightDetailsById(String id) {
        return (FlightDetails)EntityHelper.convertToDetails(getFlightEntityById(id));
    }    
    
    public Passengercb004273 getPassengerEntityById(String id){
    
        return em.find(Passengercb004273.class, id);
    }  
    
    @Override
    public PassengerDetails getPassengerDetailsById(String id) {
        return (PassengerDetails)EntityHelper.convertToDetails(getPassengerEntityById(id));
    }
    
    public Bookingcb004273 getBookingEntityById(String id)
    {
        return em.find(Bookingcb004273.class, id);
    }

    @Override
    public BookingDetails geBookingDetailsById(String id) {
        return (BookingDetails)EntityHelper.convertToDetails(getBookingEntityById(id));
    }

    @Override
    public List<BookingDetails> getBookingsByPassenger(String passengerID) {
        
        return EntityHelper.convertToDetailsList(
                                    BookingDetails.class,
                                    em.createNamedQuery("Bookingcb004273.findByPassengerid").
                                      setParameter("passengerid", passengerID).
                                      getResultList()
                                    );
    }

    @Override
    public List<BookingDetails> getBookingsByFlight(String flightID) {        
        return EntityHelper.convertToDetailsList(
                                    BookingDetails.class,
                                    em.createNamedQuery("Bookingcb004273.findByFlightid").
                                      setParameter("flightid", flightID).
                                      getResultList()
                                    );
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
