/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remin;

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
 * @author lenovo
 */
@Entity
@Table(name = "remindbt", catalog = "remindb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Remindbt.findAll", query = "SELECT r FROM Remindbt r")
    , @NamedQuery(name = "Remindbt.findByDate", query = "SELECT r FROM Remindbt r WHERE r.date = :date")
    , @NamedQuery(name = "Remindbt.findByName", query = "SELECT r FROM Remindbt r WHERE r.name = :name")
    , @NamedQuery(name = "Remindbt.findByReminder", query = "SELECT r FROM Remindbt r WHERE r.reminder = :reminder")})
public class Remindbt implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "reminder")
    private String reminder;

    public Remindbt() {
    }

    public Remindbt(Date date) {
        this.date = date;
    }

    public Remindbt(Date date, String name, String reminder) {
        this.date = date;
        this.name = name;
        this.reminder = reminder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        String oldReminder = this.reminder;
        this.reminder = reminder;
        changeSupport.firePropertyChange("reminder", oldReminder, reminder);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (date != null ? date.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remindbt)) {
            return false;
        }
        Remindbt other = (Remindbt) object;
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "remin.Remindbt[ date=" + date + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
