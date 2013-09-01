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
public class BookingDetails implements Serializable, RecordDetails{
    
    private String bookingno;
    
    private String passengerId;
    
    private String flightId;

    public BookingDetails(String bookingno, String passengerId, String flightId) {
        this.bookingno = bookingno;
        this.passengerId = passengerId;
        this.flightId = flightId;
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
    public String getPassengerId() {
        return passengerId;
    }

    /**
     * @param passenger the passenger to set
     */
    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    /**
     * @return the flight
     */
    public String getFlightId() {
        return flightId;
    }

    /**
     * @param flight the flight to set
     */
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
}
