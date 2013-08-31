/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.utils;

import java.io.Serializable;

/**
 *
 * @author KavithThiranga
 */
public class BookingDetails implements Serializable{
    
    private String bookingno;
    
    private PassengerDetails passenger;
    
    private FlightDetails flight;

    public BookingDetails(String bookingno, PassengerDetails passenger, FlightDetails flight) {
        this.bookingno = bookingno;
        this.passenger = passenger;
        this.flight = flight;
    }
    
    /**
     * @return the bookingno
     */
    public String getBookingno() {
        return bookingno;
    }

    /**
     * @param bookingno the bookingno to set
     */
    public void setBookingno(String bookingno) {
        this.bookingno = bookingno;
    }

    /**
     * @return the passenger
     */
    public PassengerDetails getPassenger() {
        return passenger;
    }

    /**
     * @param passenger the passenger to set
     */
    public void setPassenger(PassengerDetails passenger) {
        this.passenger = passenger;
    }

    /**
     * @return the flight
     */
    public FlightDetails getFlight() {
        return flight;
    }

    /**
     * @param flight the flight to set
     */
    public void setFlight(FlightDetails flight) {
        this.flight = flight;
    }
}
