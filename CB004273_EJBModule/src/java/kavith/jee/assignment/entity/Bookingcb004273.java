/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KavithThiranga
 */
@Entity
@Table(name = "BOOKINGCB004273")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookingcb004273.findAll", query = "SELECT b FROM Bookingcb004273 b"),
    @NamedQuery(name = "Bookingcb004273.findByBookingno", query = "SELECT b FROM Bookingcb004273 b WHERE b.bookingno = :bookingno")})
public class Bookingcb004273 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "BOOKINGNO")
    private String bookingno;
    @JoinColumn(name = "PASSENGERID", referencedColumnName = "PASSENGERID")
    @ManyToOne
    private Passengercb004273 passenger;
    @JoinColumn(name = "FLIGHTNO", referencedColumnName = "FLIGHTNO")
    @ManyToOne
    private Flightcb004273 flight;

    public Bookingcb004273() {
    }

    public Bookingcb004273(String bookingno, Passengercb004273 passengerid, Flightcb004273 flightno) {
        this.bookingno = bookingno;
        this.passenger = passengerid;
        this.flight = flightno;
    }

    public Bookingcb004273(String bookingno) {
        this.bookingno = bookingno;
    }

    public String getBookingno() {
        return bookingno;
    }

    public void setBookingno(String bookingno) {
        this.bookingno = bookingno;
    }

    public Passengercb004273 getPassenger() {
        return passenger;
    }

    public void setPassenger(Passengercb004273 passenger) {
        this.passenger = passenger;
    }

    public Flightcb004273 getFlight() {
        return flight;
    }

    public void setFlight(Flightcb004273 flight) {
        this.flight = flight;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingno != null ? bookingno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookingcb004273)) {
            return false;
        }
        Bookingcb004273 other = (Bookingcb004273) object;
        if ((this.bookingno == null && other.bookingno != null) || (this.bookingno != null && !this.bookingno.equals(other.bookingno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kavith.jee.assignment.entity.Bookingcb004273[ bookingno=" + bookingno + " ]";
    }
    
}
