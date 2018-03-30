/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
 * @author shivangi
 */
@Entity
@Table(catalog = "final_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visit.findAll", query = "SELECT v FROM Visit v"),
    @NamedQuery(name = "Visit.findByVid", query = "SELECT v FROM Visit v WHERE v.vid = :vid"),
    @NamedQuery(name = "Visit.findByLat", query = "SELECT v FROM Visit v WHERE v.lat = :lat"),
    @NamedQuery(name = "Visit.findByLongitude", query = "SELECT v FROM Visit v WHERE v.longitude = :longitude")})
public class Visit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer vid;
    @Lob
    @Size(max = 65535)
    private String picture;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    private BigDecimal lat;
    @Basic(optional = false)
    @NotNull
    private BigDecimal longitude;
    @Lob
    @Size(max = 65535)
    @Column(name = "REMARK_OFFICER")
    private String remarkOfficer;
    @Lob
    @Size(max = 65535)
    @Column(name = "REMARK_ADMIN")
    private String remarkAdmin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vid")
    private Collection<Answer> answerCollection;
    @JoinColumn(name = "TID", referencedColumnName = "TID")
    @ManyToOne(optional = false)
    private Task tid;
    @JoinColumn(name = "ACTION_ID", referencedColumnName = "ACTION_ID")
    @ManyToOne(optional = false)
    private Action actionId;

    public Visit() {
    }

    public Visit(Integer vid) {
        this.vid = vid;
    }

    public Visit(Integer vid, BigDecimal lat, BigDecimal longitude) {
        this.vid = vid;
        this.lat = lat;
        this.longitude = longitude;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getRemarkOfficer() {
        return remarkOfficer;
    }

    public void setRemarkOfficer(String remarkOfficer) {
        this.remarkOfficer = remarkOfficer;
    }

    public String getRemarkAdmin() {
        return remarkAdmin;
    }

    public void setRemarkAdmin(String remarkAdmin) {
        this.remarkAdmin = remarkAdmin;
    }

    @XmlTransient
    public Collection<Answer> getAnswerCollection() {
        return answerCollection;
    }

    public void setAnswerCollection(Collection<Answer> answerCollection) {
        this.answerCollection = answerCollection;
    }

    public Task getTid() {
        return tid;
    }

    public void setTid(Task tid) {
        this.tid = tid;
    }

    public Action getActionId() {
        return actionId;
    }

    public void setActionId(Action actionId) {
        this.actionId = actionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vid != null ? vid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visit)) {
            return false;
        }
        Visit other = (Visit) object;
        if ((this.vid == null && other.vid != null) || (this.vid != null && !this.vid.equals(other.vid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.DTO.Visit[ vid=" + vid + " ]";
    }
    
}
