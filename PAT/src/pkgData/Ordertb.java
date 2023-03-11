/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgData;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "ORDERTB", catalog = "", schema = "NBUSER")
@NamedQueries({
    @NamedQuery(name = "Ordertb.findAll", query = "SELECT o FROM Ordertb o"),
    @NamedQuery(name = "Ordertb.findByOrderid", query = "SELECT o FROM Ordertb o WHERE o.orderid = :orderid"),
    @NamedQuery(name = "Ordertb.findByCustomerid", query = "SELECT o FROM Ordertb o WHERE o.customerid = :customerid"),
    @NamedQuery(name = "Ordertb.findByFoodid", query = "SELECT o FROM Ordertb o WHERE o.foodid = :foodid"),
    @NamedQuery(name = "Ordertb.findByOrdertime", query = "SELECT o FROM Ordertb o WHERE o.ordertime = :ordertime")})
public class Ordertb implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORDERID")
    private Integer orderid;
    @Basic(optional = false)
    @Column(name = "CUSTOMERID")
    private int customerid;
    @Basic(optional = false)
    @Column(name = "FOODID")
    private int foodid;
    @Basic(optional = false)
    @Column(name = "ORDERTIME")
    @Temporal(TemporalType.TIME)
    private Date ordertime;

    public Ordertb() {
    }

    public Ordertb(Integer orderid) {
        this.orderid = orderid;
    }

    public Ordertb(Integer orderid, int customerid, int foodid, Date ordertime) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.foodid = foodid;
        this.ordertime = ordertime;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        Integer oldOrderid = this.orderid;
        this.orderid = orderid;
        changeSupport.firePropertyChange("orderid", oldOrderid, orderid);
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        int oldCustomerid = this.customerid;
        this.customerid = customerid;
        changeSupport.firePropertyChange("customerid", oldCustomerid, customerid);
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        int oldFoodid = this.foodid;
        this.foodid = foodid;
        changeSupport.firePropertyChange("foodid", oldFoodid, foodid);
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        Date oldOrdertime = this.ordertime;
        this.ordertime = ordertime;
        changeSupport.firePropertyChange("ordertime", oldOrdertime, ordertime);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordertb)) {
            return false;
        }
        Ordertb other = (Ordertb) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkgData.Ordertb[ orderid=" + orderid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
