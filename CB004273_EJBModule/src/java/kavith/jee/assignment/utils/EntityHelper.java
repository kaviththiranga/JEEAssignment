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
    
    public static AircraftDetails convertToAircraftDetails(Aircraftcb004273 ac)
    {
        return new AircraftDetails(
                ac.getAircraftid(), ac.getManufacturer(), 
                ac.getDetails(), ac.getCapacity()
                );
    }
    public static FlightDetails convertToFilghtDetails(Flightcb004273 f)
    {
        return new FlightDetails(
                f.getFlightno(), f.getDeptairport(), 
                f.getArrairport(), f.getDepdate(), 
                f.getArrdate(), f.getCapacity(),
                f.getAircraftid().getAircraftid()
                );
    }
    
    public static PassengerDetails convertToPassengerDetails(Passengercb004273 p)
    {
        return new PassengerDetails(
                p.getPassengerid(), p.getFname(), 
                p.getLname()
                );
    }
    
    public static BookingDetails convertToBookingDetails(Bookingcb004273 b)
    {
        return new BookingDetails(
                b.getBookingno(), 
                b.getPassenger().getPassengerid(), 
                b.getFlight().getFlightno()
                );
    }
    
    public static List<BookingDetails> convertToBookingDetailsList(List<Bookingcb004273> bl)
    {
        List<BookingDetails> bdl = new ArrayList<>();
        
        for(Bookingcb004273 b :bl)
        {
            bdl.add(convertToBookingDetails(b));
        }
        
        return bdl;
    }
    
     public static List<FlightDetails> convertTosFlightDetailsList(List<Flightcb004273> fl)
    {
        List<FlightDetails> fdl = new ArrayList<>();
        
        for(Flightcb004273 b :fl)
        {
            fdl.add(convertToFilghtDetails(b));
        }
        
        return fdl;
    }
     
    public static List<AircraftDetails> convertToAircraftDetailsList(List<Aircraftcb004273> al)
    {
        List<AircraftDetails> adl = new ArrayList<>();
        
        for(Aircraftcb004273 b :al)
        {
            adl.add(convertToAircraftDetails(b));
        }
        
        return adl;
    }
    
    public static List<PassengerDetails> convertToPassengerDetailsList(List<Passengercb004273> pl)
    {
        List<PassengerDetails> pdl = new ArrayList<>();
        
        for(Passengercb004273 b :pl)
        {
            pdl.add(convertToPassengerDetails(b));
        }
        
        return pdl;
    }
    
    public static Aircraftcb004273 convertToAircraftEntity(AircraftDetails ad)
    {
        return new Aircraftcb004273(ad.getAircraftid(), ad.getManufacturer(),
                                    ad.getDetails(), ad.getCapacity(), null);
    }
    
    public static Bookingcb004273 convertToBookingEntity(BookingDetails bd)
    {
        return new Bookingcb004273(
                                    bd.getBookingno(),
                                    null,
                                    null
                                    );
    }
}
