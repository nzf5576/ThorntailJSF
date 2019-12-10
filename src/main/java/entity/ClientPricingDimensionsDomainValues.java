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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ClientPricingDimensionsDomainValues")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientPricingDimensionsDomainValues.findAll", query = "SELECT c FROM ClientPricingDimensionsDomainValues c")
    , @NamedQuery(name = "ClientPricingDimensionsDomainValues.findByClientPricingDimensionsDomainValuesID", query = "SELECT c FROM ClientPricingDimensionsDomainValues c WHERE c.clientPricingDimensionsDomainValuesID = :clientPricingDimensionsDomainValuesID")
    , @NamedQuery(name = "ClientPricingDimensionsDomainValues.findByClientPricingDimensionsID", query = "SELECT c FROM ClientPricingDimensionsDomainValues c WHERE c.clientPricingDimensionsID = :clientPricingDimensionsID")
    , @NamedQuery(name = "ClientPricingDimensionsDomainValues.findByClientPricingDimensionsDomainValuesCode", query = "SELECT c FROM ClientPricingDimensionsDomainValues c WHERE c.clientPricingDimensionsDomainValuesCode = :clientPricingDimensionsDomainValuesCode")
    , @NamedQuery(name = "ClientPricingDimensionsDomainValues.findByClientPricingDimensionsDomainValuesDescription", query = "SELECT c FROM ClientPricingDimensionsDomainValues c WHERE c.clientPricingDimensionsDomainValuesDescription = :clientPricingDimensionsDomainValuesDescription")})
public class ClientPricingDimensionsDomainValues implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ClientPricingDimensionsDomainValuesID")
    private Integer clientPricingDimensionsDomainValuesID;
    @Column(name = "ClientPricingDimensionsID")
    private Integer clientPricingDimensionsID;
    @Size(max = 10)
    @Column(name = "ClientPricingDimensionsDomainValuesCode")
    private String clientPricingDimensionsDomainValuesCode;
    @Size(max = 45)
    @Column(name = "ClientPricingDimensionsDomainValuesDescription")
    private String clientPricingDimensionsDomainValuesDescription;

    public ClientPricingDimensionsDomainValues() {
    }

    public ClientPricingDimensionsDomainValues(Integer clientPricingDimensionsDomainValuesID) {
        this.clientPricingDimensionsDomainValuesID = clientPricingDimensionsDomainValuesID;
    }

    public Integer getClientPricingDimensionsDomainValuesID() {
        return clientPricingDimensionsDomainValuesID;
    }

    public void setClientPricingDimensionsDomainValuesID(Integer clientPricingDimensionsDomainValuesID) {
        this.clientPricingDimensionsDomainValuesID = clientPricingDimensionsDomainValuesID;
    }

    public Integer getClientPricingDimensionsID() {
        return clientPricingDimensionsID;
    }

    public void setClientPricingDimensionsID(Integer clientPricingDimensionsID) {
        this.clientPricingDimensionsID = clientPricingDimensionsID;
    }

    public String getClientPricingDimensionsDomainValuesCode() {
        return clientPricingDimensionsDomainValuesCode;
    }

    public void setClientPricingDimensionsDomainValuesCode(String clientPricingDimensionsDomainValuesCode) {
        this.clientPricingDimensionsDomainValuesCode = clientPricingDimensionsDomainValuesCode;
    }

    public String getClientPricingDimensionsDomainValuesDescription() {
        return clientPricingDimensionsDomainValuesDescription;
    }

    public void setClientPricingDimensionsDomainValuesDescription(String clientPricingDimensionsDomainValuesDescription) {
        this.clientPricingDimensionsDomainValuesDescription = clientPricingDimensionsDomainValuesDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientPricingDimensionsDomainValuesID != null ? clientPricingDimensionsDomainValuesID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientPricingDimensionsDomainValues)) {
            return false;
        }
        ClientPricingDimensionsDomainValues other = (ClientPricingDimensionsDomainValues) object;
        if ((this.clientPricingDimensionsDomainValuesID == null && other.clientPricingDimensionsDomainValuesID != null) || (this.clientPricingDimensionsDomainValuesID != null && !this.clientPricingDimensionsDomainValuesID.equals(other.clientPricingDimensionsDomainValuesID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClientPricingDimensionsDomainValues[ clientPricingDimensionsDomainValuesID=" + clientPricingDimensionsDomainValuesID + " ]";
    }
    
}
