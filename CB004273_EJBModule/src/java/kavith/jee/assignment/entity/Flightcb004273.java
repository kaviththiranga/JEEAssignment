/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author KavithThiranga
 */
@Entity
@Table(name = "FLIGHTCB004273")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flightcb004273.findAll", query = "SELECT f FROM Flightcb004273 f"),
    @NamedQuery(name = "Flightcb004273.findByFlightno", query = "SELECT f FROM Flightcb004273 f WHERE f.flightno = :flightno"),
    @NamedQuery(name = "Flightcb004273.findByDeptairport", query = "SELECT f FROM Flightcb004273 f WHERE f.deptairport = :deptairport"),
    @NamedQuery(name = "Flightcb004273.findByArrairport", query = "SELECT f FROM Flightcb004273 f WHERE f.arrairport = :arrairport"),
    @NamedQuery(name = "Flightcb004273.findByDepdate", query = "SELECT f FROM Flightcb004273 f WHERE f.depdate = :depdate"),
    @NamedQuery(name = "Flightcb004273.findByArrdate", query = "SELECT f FROM Flightcb004273 f WHERE f.arrdate = :arrdate"),
    @NamedQuery(name = "Flightcb004273.findByCapacity", query = "SELECT f FROM Flightcb004273 f WHERE f.capacity = :capacity")})
public class Flightcb004273 implements Serializable, RecordEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FLIGHTNO")
    private String flightno;
    @Size(max = 20)
    @Column(name = "DEPTAIRPORT")
    private String deptairport;
    @Size(max = 20)
    @Column(name = "ARRAIRPORT")
    private String arrairport;
    @Column(name = "DEPDATE")
    @Temporal(TemporalType.DATE)
    private Date depdate;
    @Column(name = "ARRDATE")
    @Temporal(TemporalType.DATE)
    private Date arrdate;
    @Column(name = "CAPACITY")
    private Short capacity;
    @OneToMany(mappedBy = "flightno")
    private List<Bookingcb004273> bookingcb004273List;
    @JoinColumn(name = "AIRCRAFTID", referencedColumnName = "AIRCRAFTID")
    @ManyToOne
    private Aircraftcb004273 aircraftid;

    public Flightcb004273() {
    }

    public Flightcb004273(String flightno, String deptairport, String arrairport, Date depdate, Date arrdate, Short capacity, List<Bookingcb004273> bookingcb004273List, Aircraftcb004273 aircraftid) {
        this.flightno = flightno;
        this.deptairport = deptairport;
        this.arrairport = arrairport;
        this.depdate = depdate;
        this.arrdate = arrdate;
        this.capacity = capacity;
        this.bookingcb004273List = bookingcb004273List;
        this.aircraftid = aircraftid;
    }

    public Flightcb004273(String flightno) {
        this.flightno = flightno;
    }

    public String getFlightno() {
        return flightno;
    }

    public void setFlightno(String flightno) {
        this.flightno = flightno;
    }

    public String getDeptairport() {
        return deptairport;
    }

    public void setDeptairport(String deptairport) {
        this.deptairport = deptairport;
    }

    public String getArrairport() {
        return arrairport;
    }

    public void setArrairport(String arrairport) {
        this.arrairport = arrairport;
    }

    public Date getDepdate() {
        return depdate;
    }

    public void setDepdate(Date depdate) {
        this.depdate = depdate;
    }

    public Date getArrdate() {
        return arrdate;
    }

    public void setArrdate(Date arrdate) {
        this.arrdate = arrdate;
    }

    public Short getCapacity() {
        return capacity;
    }

    public void setCapacity(Short capacity) {
        this.capacity = capacity;
    }

    @XmlTransient
    public List<Bookingcb004273> getBookingcb004273List() {
        return bookingcb004273List;
    }

    public void setBookingcb004273List(List<Bookingcb004273> bookingcb004273List) {
        this.bookingcb004273List = bookingcb004273List;
    }

    public Aircraftcb004273 getAircraftid() {
        return aircraftid;
    }

    public void setAircraftid(Aircraftcb004273 aircraftid) {
        this.aircraftid = aircraftid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightno != null ? flightno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flightcb004273)) {
            return false;
        }
        Flightcb004273 other = (Flightcb004273) object;
        if ((this.flightno == null && other.flightno != null) || (this.flightno != null && !this.flightno.equals(other.flightno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kavith.jee.assignment.entity.Flightcb004273[ flightno=" + flightno + " ]";
    }
    
}
