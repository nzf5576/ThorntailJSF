/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ClientProductBundleDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientProductBundleDetail.findAll", query = "SELECT c FROM ClientProductBundleDetail c")
    , @NamedQuery(name = "ClientProductBundleDetail.findByClientProductBundleDetailID", query = "SELECT c FROM ClientProductBundleDetail c WHERE c.clientProductBundleDetailID = :clientProductBundleDetailID")
    , @NamedQuery(name = "ClientProductBundleDetail.findByClientProductBundleID", query = "SELECT c FROM ClientProductBundleDetail c WHERE c.clientProductBundleID = :clientProductBundleID")
    , @NamedQuery(name = "ClientProductBundleDetail.findByClientCatalogProductsID", query = "SELECT c FROM ClientProductBundleDetail c WHERE c.clientCatalogProductsID = :clientCatalogProductsID")})
public class ClientProductBundleDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ClientProductBundleDetailID")
    private Integer clientProductBundleDetailID;
    @Column(name = "ClientProductBundleID")
    private Integer clientProductBundleID;
    @Column(name = "ClientCatalogProductsID")
    private Integer clientCatalogProductsID;

    public ClientProductBundleDetail() {
    }

    public ClientProductBundleDetail(Integer clientProductBundleDetailID) {
        this.clientProductBundleDetailID = clientProductBundleDetailID;
    }

    public Integer getClientProductBundleDetailID() {
        return clientProductBundleDetailID;
    }

    public void setClientProductBundleDetailID(Integer clientProductBundleDetailID) {
        this.clientProductBundleDetailID = clientProductBundleDetailID;
    }

    public Integer getClientProductBundleID() {
        return clientProductBundleID;
    }

    public void setClientProductBundleID(Integer clientProductBundleID) {
        this.clientProductBundleID = clientProductBundleID;
    }

    public Integer getClientCatalogProductsID() {
        return clientCatalogProductsID;
    }

    public void setClientCatalogProductsID(Integer clientCatalogProductsID) {
        this.clientCatalogProductsID = clientCatalogProductsID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientProductBundleDetailID != null ? clientProductBundleDetailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientProductBundleDetail)) {
            return false;
        }
        ClientProductBundleDetail other = (ClientProductBundleDetail) object;
        if ((this.clientProductBundleDetailID == null && other.clientProductBundleDetailID != null) || (this.clientProductBundleDetailID != null && !this.clientProductBundleDetailID.equals(other.clientProductBundleDetailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClientProductBundleDetail[ clientProductBundleDetailID=" + clientProductBundleDetailID + " ]";
    }
    
}
