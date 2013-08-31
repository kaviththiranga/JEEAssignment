/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.utils;

import java.util.ArrayList;
import java.util.List;
import kavith.jee.assignment.entity.*;
/**
 *
 * @author KavithThiranga
 */
public class EntityHelper {
    
    public static AircraftDetails getAircraftDetails(Aircraftcb004273 ac)
    {
        return new AircraftDetails(
                ac.getAircraftid(), ac.getManufacturer(), 
                ac.getDetails(), ac.getCapacity()
                );
    }
    public static FlightDetails getFilghtDetails(Flightcb004273 f)
    {
        return new FlightDetails(
                f.getFlightno(), f.getDeptairport(), 
                f.getArrairport(), f.getDepdate(), 
                f.getArrdate(), f.getCapacity(),
                getAircraftDetails(f.getAircraftid())
                );
    }
    
    public static PassengerDetails getPassengerDetails(Passengercb004273 p)
    {
        return new PassengerDetails(
                p.getPassengerid(), p.getFname(), 
                p.getLname()
                );
    }
    
    public static BookingDetails getBookingDetails(Bookingcb004273 b)
    {
        return new BookingDetails(
                b.getBookingno(), 
                getPassengerDetails(b.getPassengerid()), 
                getFilghtDetails(b.getFlightno())
                );
    }
    
    public static List<BookingDetails> getBookingDetailsList(List<Bookingcb004273> bl)
    {
        List<BookingDetails> bdl = new ArrayList<>();
        
        for(Bookingcb004273 b :bl)
        {
            bdl.add(getBookingDetails(b));
        }
        
        return bdl;
    }
    
     public static List<FlightDetails> getFlightDetailsList(List<Flightcb004273> fl)
    {
        List<FlightDetails> fdl = new ArrayList<>();
        
        for(Flightcb004273 b :fl)
        {
            fdl.add(getFilghtDetails(b));
        }
        
        return fdl;
    }
     
    public static List<AircraftDetails> getAircraftDetailsList(List<Aircraftcb004273> al)
    {
        List<AircraftDetails> adl = new ArrayList<>();
        
        for(Aircraftcb004273 b :al)
        {
            adl.add(getAircraftDetails(b));
        }
        
        return adl;
    }
    
    public static List<PassengerDetails> getPassengerDetailsList(List<Passengercb004273> pl)
    {
        List<PassengerDetails> pdl = new ArrayList<>();
        
        for(Passengercb004273 b :pl)
        {
            pdl.add(getPassengerDetails(b));
        }
        
        return pdl;
    }
}
