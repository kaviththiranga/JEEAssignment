/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.utils;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author KavithThiranga
 */
public class AircraftDetails implements Serializable{
   
    private String aircraftid;
   
    private String manufacturer;
    
    private String details;
   
    private Short capacity;

    public AircraftDetails(String aircraftid, String manufacturer, String details, Short capacity) {
        this.aircraftid = aircraftid;
        this.manufacturer = manufacturer;
        this.details = details;
        this.capacity = capacity;
    }

    /**
     * @return the aircraftid
     */
    public String getAircraftid() {
        return aircraftid;
    }

    /**
     * @param aircraftid the aircraftid to set
     */
    public void setAircraftid(String aircraftid) {
        this.aircraftid = aircraftid;
    }

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(String details) {
        this.details = details;
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

}
