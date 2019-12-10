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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ClientPricingDimensions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientPricingDimensions.findAll", query = "SELECT c FROM ClientPricingDimensions c")
    , @NamedQuery(name = "ClientPricingDimensions.findByClientPricingDimensionsID", query = "SELECT c FROM ClientPricingDimensions c WHERE c.clientPricingDimensionsID = :clientPricingDimensionsID")
    , @NamedQuery(name = "ClientPricingDimensions.findByClientPricingDimensionsCode", query = "SELECT c FROM ClientPricingDimensions c WHERE c.clientPricingDimensionsCode = :clientPricingDimensionsCode")
    , @NamedQuery(name = "ClientPricingDimensions.findByDescription", query = "SELECT c FROM ClientPricingDimensions c WHERE c.description = :description")})
public class ClientPricingDimensions implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Basic(optional = false)
    @Column(name = "ClientPricingDimensionsID")
    private Integer clientPricingDimensionsID;
    
    @Size(max = 10)
    @Column(name = "ClientPricingDimensionsCode")
    private String clientPricingDimensionsCode;
    
    @Size(max = 45)
    @Column(name = "Description")
    private String description;

    public ClientPricingDimensions() {
    }

    public ClientPricingDimensions(Integer clientPricingDimensionsID) {
        this.clientPricingDimensionsID = clientPricingDimensionsID;
    }

    public Integer getClientPricingDimensionsID() {
        return clientPricingDimensionsID;
    }

    public void setClientPricingDimensionsID(Integer clientPricingDimensionsID) {
        this.clientPricingDimensionsID = clientPricingDimensionsID;
    }

    public String getClientPricingDimensionsCode() {
        return clientPricingDimensionsCode;
    }

    public void setClientPricingDimensionsCode(String clientPricingDimensionsCode) {
        this.clientPricingDimensionsCode = clientPricingDimensionsCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientPricingDimensionsID != null ? clientPricingDimensionsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientPricingDimensions)) {
            return false;
        }
        ClientPricingDimensions other = (ClientPricingDimensions) object;
        if ((this.clientPricingDimensionsID == null && other.clientPricingDimensionsID != null) || (this.clientPricingDimensionsID != null && !this.clientPricingDimensionsID.equals(other.clientPricingDimensionsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClientPricingDimensions[ clientPricingDimensionsID=" + clientPricingDimensionsID + " ]";
    }
    
}
