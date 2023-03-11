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
@Table(name = "FOODTB", catalog = "", schema = "NBUSER")
@NamedQueries({
    @NamedQuery(name = "Foodtb.findAll", query = "SELECT f FROM Foodtb f"),
    @NamedQuery(name = "Foodtb.findByFoodid", query = "SELECT f FROM Foodtb f WHERE f.foodid = :foodid"),
    @NamedQuery(name = "Foodtb.findByFoodname", query = "SELECT f FROM Foodtb f WHERE f.foodname = :foodname"),
    @NamedQuery(name = "Foodtb.findByFoodprice", query = "SELECT f FROM Foodtb f WHERE f.foodprice = :foodprice"),
    @NamedQuery(name = "Foodtb.findByFoodquantity", query = "SELECT f FROM Foodtb f WHERE f.foodquantity = :foodquantity"),
    @NamedQuery(name = "Foodtb.findByPreptime", query = "SELECT f FROM Foodtb f WHERE f.preptime = :preptime")})
public class Foodtb implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FOODID")
    private Integer foodid;
    @Basic(optional = false)
    @Column(name = "FOODNAME")
    private String foodname;
    @Basic(optional = false)
    @Column(name = "FOODPRICE")
    private double foodprice;
    @Basic(optional = false)
    @Column(name = "FOODQUANTITY")
    private int foodquantity;
    @Basic(optional = false)
    @Column(name = "PREPTIME")
    private int preptime;

    public Foodtb() {
    }

    public Foodtb(Integer foodid) {
        this.foodid = foodid;
    }

    public Foodtb(Integer foodid, String foodname, double foodprice, int foodquantity, int preptime) {
        this.foodid = foodid;
        this.foodname = foodname;
        this.foodprice = foodprice;
        this.foodquantity = foodquantity;
        this.preptime = preptime;
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        Integer oldFoodid = this.foodid;
        this.foodid = foodid;
        changeSupport.firePropertyChange("foodid", oldFoodid, foodid);
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        String oldFoodname = this.foodname;
        this.foodname = foodname;
        changeSupport.firePropertyChange("foodname", oldFoodname, foodname);
    }

    public double getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(double foodprice) {
        double oldFoodprice = this.foodprice;
        this.foodprice = foodprice;
        changeSupport.firePropertyChange("foodprice", oldFoodprice, foodprice);
    }

    public int getFoodquantity() {
        return foodquantity;
    }

    public void setFoodquantity(int foodquantity) {
        int oldFoodquantity = this.foodquantity;
        this.foodquantity = foodquantity;
        changeSupport.firePropertyChange("foodquantity", oldFoodquantity, foodquantity);
    }

    public int getPreptime() {
        return preptime;
    }

    public void setPreptime(int preptime) {
        int oldPreptime = this.preptime;
        this.preptime = preptime;
        changeSupport.firePropertyChange("preptime", oldPreptime, preptime);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodid != null ? foodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foodtb)) {
            return false;
        }
        Foodtb other = (Foodtb) object;
        if ((this.foodid == null && other.foodid != null) || (this.foodid != null && !this.foodid.equals(other.foodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkgData.Foodtb[ foodid=" + foodid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
