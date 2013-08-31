/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author KavithThiranga
 */
public class FlightDetails implements Serializable{
  
    private String flightno;
   
    private String deptairport;
  
    private String arrairport;
    
    private Date depdate;
   
    private Date arrdate;
    
    private Short capacity;
    
    private AircraftDetails aircraft;

    public FlightDetails(String flightno, String deptairport, String arrairport, Date depdate, Date arrdate, Short capacity, AircraftDetails aircraft) {
        this.flightno = flightno;
        this.deptairport = deptairport;
        this.arrairport = arrairport;
        this.depdate = depdate;
        this.arrdate = arrdate;
        this.capacity = capacity;
        this.aircraft = aircraft;
    }
    
    /**
     * @return the flightno
     */
    public String getFlightno() {
        return flightno;
    }

    /**
     * @param flightno the flightno to set
     */
    public void setFlightno(String flightno) {
        this.flightno = flightno;
    }

    /**
     * @return the deptairport
     */
    public String getDeptairport() {
        return deptairport;
    }

    /**
     * @param deptairport the deptairport to set
     */
    public void setDeptairport(String deptairport) {
        this.deptairport = deptairport;
    }

    /**
     * @return the arrairport
     */
    public String getArrairport() {
        return arrairport;
    }

    /**
     * @param arrairport the arrairport to set
     */
    public void setArrairport(String arrairport) {
        this.arrairport = arrairport;
    }

    /**
     * @return the depdate
     */
    public Date getDepdate() {
        return depdate;
    }

    /**
     * @param depdate the depdate to set
     */
    public void setDepdate(Date depdate) {
        this.depdate = depdate;
    }

    /**
     * @return the arrdate
     */
    public Date getArrdate() {
        return arrdate;
    }

    /**
     * @param arrdate the arrdate to set
     */
    public void setArrdate(Date arrdate) {
        this.arrdate = arrdate;
    }

    /**
     * @return the capacity
     */
    public Short getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(Short capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the aircraft
     */
    public AircraftDetails getAircraft() {
        return aircraft;
    }

    /**
     * @param aircraft the aircraft to set
     */
    public void setAircraft(AircraftDetails aircraft) {
        this.aircraft = aircraft;
    }
}
