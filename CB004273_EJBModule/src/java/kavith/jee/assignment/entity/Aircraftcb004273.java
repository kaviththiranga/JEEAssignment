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
@Table(name = "AIRCRAFTCB004273")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aircraftcb004273.findAll", query = "SELECT a FROM Aircraftcb004273 a"),
    @NamedQuery(name = "Aircraftcb004273.findByAircraftid", query = "SELECT a FROM Aircraftcb004273 a WHERE a.aircraftid = :aircraftid"),
    @NamedQuery(name = "Aircraftcb004273.findByManufacturer", query = "SELECT a FROM Aircraftcb004273 a WHERE a.manufacturer = :manufacturer"),
    @NamedQuery(name = "Aircraftcb004273.findByDetails", query = "SELECT a FROM Aircraftcb004273 a WHERE a.details = :details"),
    @NamedQuery(name = "Aircraftcb004273.findByCapacity", query = "SELECT a FROM Aircraftcb004273 a WHERE a.capacity = :capacity")})
public class Aircraftcb004273 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "AIRCRAFTID")
    private String aircraftid;
    @Size(max = 20)
    @Column(name = "MANUFACTURER")
    private String manufacturer;
    @Size(max = 20)
    @Column(name = "DETAILS")
    private String details;
    @Column(name = "CAPACITY")
    private Short capacity;
    @OneToMany(mappedBy = "aircraftid")
    private List<Flightcb004273> flightcb004273List;

    public Aircraftcb004273() {
    }

    public Aircraftcb004273(String aircraftid, String manufacturer, String details, Short capacity, List<Flightcb004273> flightcb004273List) {
        this.aircraftid = aircraftid;
        this.manufacturer = manufacturer;
        this.details = details;
        this.capacity = capacity;
        this.flightcb004273List = flightcb004273List;
    }    

    public Aircraftcb004273(String aircraftid) {
        this.aircraftid = aircraftid;
    }

    public String getAircraftid() {
        return aircraftid;
    }

    public void setAircraftid(String aircraftid) {
        this.aircraftid = aircraftid;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Short getCapacity() {
        return capacity;
    }

    public void setCapacity(Short capacity) {
        this.capacity = capacity;
    }

    @XmlTransient
    public List<Flightcb004273> getFlightcb004273List() {
        return flightcb004273List;
    }

    public void setFlightcb004273List(List<Flightcb004273> flightcb004273List) {
        this.flightcb004273List = flightcb004273List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aircraftid != null ? aircraftid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aircraftcb004273)) {
            return false;
        }
        Aircraftcb004273 other = (Aircraftcb004273) object;
        if ((this.aircraftid == null && other.aircraftid != null) || (this.aircraftid != null && !this.aircraftid.equals(other.aircraftid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kavith.jee.assignment.entity.Aircraftcb004273[ aircraftid=" + aircraftid + " ]";
    }
    
}
