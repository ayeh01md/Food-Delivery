/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgData;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "CUSTOMERTB", catalog = "", schema = "NBUSER")
@NamedQueries({
    @NamedQuery(name = "Customertb.findAll", query = "SELECT c FROM Customertb c"),
    @NamedQuery(name = "Customertb.findByCustomerid", query = "SELECT c FROM Customertb c WHERE c.customerid = :customerid"),
    @NamedQuery(name = "Customertb.findByFirstname", query = "SELECT c FROM Customertb c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Customertb.findByLastname", query = "SELECT c FROM Customertb c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "Customertb.findByPhonenumber", query = "SELECT c FROM Customertb c WHERE c.phonenumber = :phonenumber"),
    @NamedQuery(name = "Customertb.findByAddress", query = "SELECT c FROM Customertb c WHERE c.address = :address")})
public class Customertb implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CUSTOMERID")
    private Integer customerid;
    @Basic(optional = false)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;

    public Customertb() {
    }

    public Customertb(Integer customerid) {
        this.customerid = customerid;
    }

    public Customertb(Integer customerid, String firstname, String lastname, String phonenumber, String address) {
        this.customerid = customerid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.address = address;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        Integer oldCustomerid = this.customerid;
        this.customerid = customerid;
        changeSupport.firePropertyChange("customerid", oldCustomerid, customerid);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        String oldFirstname = this.firstname;
        this.firstname = firstname;
        changeSupport.firePropertyChange("firstname", oldFirstname, firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        String oldLastname = this.lastname;
        this.lastname = lastname;
        changeSupport.firePropertyChange("lastname", oldLastname, lastname);
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        String oldPhonenumber = this.phonenumber;
        this.phonenumber = phonenumber;
        changeSupport.firePropertyChange("phonenumber", oldPhonenumber, phonenumber);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerid != null ? customerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customertb)) {
            return false;
        }
        Customertb other = (Customertb) object;
        if ((this.customerid == null && other.customerid != null) || (this.customerid != null && !this.customerid.equals(other.customerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkgData.Customertb[ customerid=" + customerid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
