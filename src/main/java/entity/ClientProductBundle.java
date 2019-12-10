/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ClientProductBundle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientProductBundle.findAll", query = "SELECT c FROM ClientProductBundle c")
    , @NamedQuery(name = "ClientProductBundle.findByClientProductBundleID", query = "SELECT c FROM ClientProductBundle c WHERE c.clientProductBundleID = :clientProductBundleID")
    , @NamedQuery(name = "ClientProductBundle.findByBundleName", query = "SELECT c FROM ClientProductBundle c WHERE c.bundleName = :bundleName")
    , @NamedQuery(name = "ClientProductBundle.findByPricingType", query = "SELECT c FROM ClientProductBundle c WHERE c.pricingType = :pricingType")
    , @NamedQuery(name = "ClientProductBundle.findByCreatedDate", query = "SELECT c FROM ClientProductBundle c WHERE c.createdDate = :createdDate")
    , @NamedQuery(name = "ClientProductBundle.findByModifiedDate", query = "SELECT c FROM ClientProductBundle c WHERE c.modifiedDate = :modifiedDate")
    , @NamedQuery(name = "ClientProductBundle.findByCreatedBy", query = "SELECT c FROM ClientProductBundle c WHERE c.createdBy = :createdBy")
    , @NamedQuery(name = "ClientProductBundle.findByModifiedBy", query = "SELECT c FROM ClientProductBundle c WHERE c.modifiedBy = :modifiedBy")})
public class ClientProductBundle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ClientProductBundleID")
    private Integer clientProductBundleID;
    @Size(max = 45)
    @Column(name = "BundleName")
    private String bundleName;
    @Size(max = 2)
    @Column(name = "PricingType")
    private String pricingType;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Size(max = 10)
    @Column(name = "CreatedBy")
    private String createdBy;
    @Size(max = 10)
    @Column(name = "ModifiedBy")
    private String modifiedBy;

    public ClientProductBundle() {
    }

    public ClientProductBundle(Integer clientProductBundleID) {
        this.clientProductBundleID = clientProductBundleID;
    }

    public Integer getClientProductBundleID() {
        return clientProductBundleID;
    }

    public void setClientProductBundleID(Integer clientProductBundleID) {
        this.clientProductBundleID = clientProductBundleID;
    }

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }

    public String getPricingType() {
        return pricingType;
    }

    public void setPricingType(String pricingType) {
        this.pricingType = pricingType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientProductBundleID != null ? clientProductBundleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientProductBundle)) {
            return false;
        }
        ClientProductBundle other = (ClientProductBundle) object;
        if ((this.clientProductBundleID == null && other.clientProductBundleID != null) || (this.clientProductBundleID != null && !this.clientProductBundleID.equals(other.clientProductBundleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClientProductBundle[ clientProductBundleID=" + clientProductBundleID + " ]";
    }
    
}
