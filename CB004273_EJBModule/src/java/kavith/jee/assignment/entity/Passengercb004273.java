/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author KavithThiranga
 */
@Entity
@Table(name = "PASSENGERCB004273")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passengercb004273.findAll", query = "SELECT p FROM Passengercb004273 p"),
    @NamedQuery(name = "Passengercb004273.findByPassengerid", query = "SELECT p FROM Passengercb004273 p WHERE p.passengerid = :passengerid"),
    @NamedQuery(name = "Passengercb004273.findByFname", query = "SELECT p FROM Passengercb004273 p WHERE p.fname = :fname"),
    @NamedQuery(name = "Passengercb004273.findByLname", query = "SELECT p FROM Passengercb004273 p WHERE p.lname = :lname")})
public class Passengercb004273 implements Serializable, RecordEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PASSENGERID")
    private String passengerid;
    @Size(max = 20)
    @Column(name = "FNAME")
    private String fname;
    @Size(max = 20)
    @Column(name = "LNAME")
    private String lname;
    @OneToMany(mappedBy = "passenger")
    private List<Bookingcb004273> bookingcb004273List;

    public Passengercb004273() {
    }

    public Passengercb004273(String passengerid, String fname, String lname, List<Bookingcb004273> bookingcb004273List) {
        this.passengerid = passengerid;
        this.fname = fname;
        this.lname = lname;
        this.bookingcb004273List = bookingcb004273List;
    }

    public Passengercb004273(String passengerid) {
        this.passengerid = passengerid;
    }

    public String getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(String passengerid) {
        this.passengerid = passengerid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @XmlTransient
    public List<Bookingcb004273> getBookingcb004273List() {
        return bookingcb004273List;
    }

    public void setBookingcb004273List(List<Bookingcb004273> bookingcb004273List) {
        this.bookingcb004273List = bookingcb004273List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (passengerid != null ? passengerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passengercb004273)) {
            return false;
        }
        Passengercb004273 other = (Passengercb004273) object;
        if ((this.passengerid == null && other.passengerid != null) || (this.passengerid != null && !this.passengerid.equals(other.passengerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kavith.jee.assignment.entity.Passengercb004273[ passengerid=" + passengerid + " ]";
    }
    
}
