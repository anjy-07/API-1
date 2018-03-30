/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DTO;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Officer.findAll", query = "SELECT o FROM Officer o"),
    @NamedQuery(name = "Officer.findByOid", query = "SELECT o FROM Officer o WHERE o.oid = :oid"),
    @NamedQuery(name = "Officer.findByMobile", query = "SELECT o FROM Officer o WHERE o.mobile = :mobile"),
    @NamedQuery(name = "Officer.findByAadharCard", query = "SELECT o FROM Officer o WHERE o.aadharCard = :aadharCard"),
    @NamedQuery(name = "Officer.findByDoj", query = "SELECT o FROM Officer o WHERE o.doj = :doj"),
    @NamedQuery(name = "Officer.findByRtd", query = "SELECT o FROM Officer o WHERE o.rtd = :rtd"),
    @NamedQuery(name = "Officer.findByAdminRights", query = "SELECT o FROM Officer o WHERE o.adminRights = :adminRights")})
public class Officer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer oid;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "EMAIL_ID")
    private String emailId;
    @Basic(optional = false)
    @NotNull
    private int mobile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AADHAR_CARD")
    private int aadharCard;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "TOKEN_ID")
    private String tokenId;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private String doj;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private String rtd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ADMIN_RIGHTS")
    private String adminRights;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oid")
    private Collection<Task> taskCollection;
    @JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
    @ManyToOne(optional = false)
    private Office officeId;

    public Officer() {
    }

    public Officer(Integer oid) {
        this.oid = oid;
    }

    public Officer(Integer oid, String name, String designation, String emailId, int mobile, int aadharCard, String password, String tokenId, String doj, String rtd, String adminRights) {
        this.oid = oid;
        this.name = name;
        this.designation = designation;
        this.emailId = emailId;
        this.mobile = mobile;
        this.aadharCard = aadharCard;
        this.password = password;
        this.tokenId = tokenId;
        this.doj = doj;
        this.rtd = rtd;
        this.adminRights = adminRights;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getAadharCard() {
        return aadharCard;
    }

    public void setAadharCard(int aadharCard) {
        this.aadharCard = aadharCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getRtd() {
        return rtd;
    }

    public void setRtd(String rtd) {
        this.rtd = rtd;
    }

    public String getAdminRights() {
        return adminRights;
    }

    public void setAdminRights(String adminRights) {
        this.adminRights = adminRights;
    }

    @XmlTransient
    public Collection<Task> getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(Collection<Task> taskCollection) {
        this.taskCollection = taskCollection;
    }

    public Office getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Office officeId) {
        this.officeId = officeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Officer)) {
            return false;
        }
        Officer other = (Officer) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.DTO.Officer[ oid=" + oid + " ]";
    }
    
}
