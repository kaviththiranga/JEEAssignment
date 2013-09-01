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
public class PassengerDetails implements Serializable, RecordDetails{
  
    private String passengerid;
   
    private String fname;
   
    private String lname;

    public PassengerDetails(String passengerid, String fname, String lname) {
        this.passengerid = passengerid;
        this.fname = fname;
        this.lname = lname;
    }

    /**
     * @return the passengerid
     */
    public String getPassengerid() {
        return passengerid;
    }

    /**
     * @param passengerid the passengerid to set
     */
    public void setPassengerid(String passengerid) {
        this.passengerid = passengerid;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

}
