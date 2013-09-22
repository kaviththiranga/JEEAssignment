/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import kavith.jee.assignment.entity.*;
import kavith.jee.assignment.service.DataQuerySerivceBeanRemote;
import kavith.jee.assignment.service.DataQueryServiceLocal;

/**
 *
 * @author KavithThiranga
 */
public class EntityHelper { 
    static DataQueryServiceLocal dbLocal = lookupDataQuerySerivceBeanLocal();
    
    static DataQuerySerivceBeanRemote  dbRemote = lookupDataQuerySerivceBeanRemote();
    
    
    private static AircraftDetails convertToAircraftDetails(Aircraftcb004273 ac)
    {
        return new AircraftDetails(
                ac.getAircraftid(), ac.getManufacturer(), 
                ac.getDetails(), ac.getCapacity()
                );
    }
    private static FlightDetails convertToFlightDetails(Flightcb004273 f)
    {
        return new FlightDetails(
                f.getFlightno(), f.getDeptairport(), 
                f.getArrairport(), f.getDepdate(), 
                f.getArrdate(), f.getCapacity(),
                f.getAircraftid().getAircraftid()
                );
    }
    
    private static PassengerDetails convertToPassengerDetails(Passengercb004273 p)
    {
        return new PassengerDetails(
                p.getPassengerid(), p.getFname(), 
                p.getLname()
                );
    }
    
    private static BookingDetails convertToBookingDetails(Bookingcb004273 b)
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
            fdl.add(convertToFlightDetails(b));
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
    
    private static Aircraftcb004273 convertToAircraftEntity(AircraftDetails ad)
    {
        return new Aircraftcb004273(ad.getAircraftid(), ad.getManufacturer(),
                                    ad.getDetails(), ad.getCapacity(), null);
    }
    
    private static Bookingcb004273 convertToBookingEntity(BookingDetails bd)
    {
        return new Bookingcb004273(
                                    bd.getBookingno(),
                                    dbLocal.getPassengerEntityById(bd.getPassengerId()),
                                    dbLocal.getFlightEntityById(bd.getFlightId())
                                    );
    } 
    
    private static Flightcb004273 convertToFlightEntity(FlightDetails fd)
    {
        return new Flightcb004273(fd.getFlightno(),
                fd.getDeptairport(), fd.getArrairport(), fd.getDepdate(), fd.getArrdate(),
                fd.getCapacity(), new ArrayList<Bookingcb004273>(),dbLocal.getAircraftEntityById(fd.getAircraftId()));
    }
    
    private static Passengercb004273 convertToPassengerEntity(PassengerDetails pd)
    {
        return new Passengercb004273(pd.getPassengerid(), pd.getFname(),
                                    pd.getLname(), null);
    }
    
    public static RecordDetails convertToDetails(RecordEntity obj)
    {
         if(obj instanceof Aircraftcb004273)
                return convertToAircraftDetails((Aircraftcb004273)obj);
         else if(obj instanceof Flightcb004273)
                return convertToFlightDetails((Flightcb004273)obj);
         else if(obj instanceof Bookingcb004273)
                return convertToBookingDetails((Bookingcb004273)obj);
         else if(obj instanceof Passengercb004273)
                return convertToPassengerDetails((Passengercb004273)obj);
         
         return null;
    }
    
    public static RecordEntity convertToEntity(RecordDetails obj)
    {
         if(obj instanceof AircraftDetails)
                return convertToAircraftEntity((AircraftDetails)obj);
         else if(obj instanceof FlightDetails)
                return convertToFlightEntity((FlightDetails)obj);
         else if(obj instanceof BookingDetails)
                return convertToBookingEntity((BookingDetails)obj);
         else if(obj instanceof PassengerDetails)
                return convertToPassengerEntity((PassengerDetails)obj);
         
         return null;
    }
    
    public static <T> List<T> convertToDetailsList(Class<T> cls , List<RecordEntity> lst)
    {
            List<T> newlst = new ArrayList<>();
            
            for(RecordEntity obj :lst){
                newlst.add((T)convertToDetails(obj));
            }
            return newlst;
    }

    private static DataQuerySerivceBeanRemote lookupDataQuerySerivceBeanRemote() {
        try {
            Context c = new InitialContext();
            return (DataQuerySerivceBeanRemote) c.lookup("java:global/CB004273_EJBModule/DataQuerySerivceBean!kavith.jee.assignment.service.DataQuerySerivceBeanRemote");
        } catch (NamingException ne) {
            Logger.getLogger("EntityHelper").log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private static DataQueryServiceLocal lookupDataQuerySerivceBeanLocal() {
        try {
            Context c = new InitialContext();
            return (DataQueryServiceLocal) c.lookup("java:global/CB004273_EJBModule/DataQuerySerivceBean!kavith.jee.assignment.service.DataQueryServiceLocal");
        } catch (NamingException ne) {
            Logger.getLogger("EntityHelper").log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
