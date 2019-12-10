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
@Table(name = "ClientCatalogProducts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientCatalogProducts.findAll", query = "SELECT c FROM ClientCatalogProducts c")
    , @NamedQuery(name = "ClientCatalogProducts.findByClientCatalogID", query = "SELECT c FROM ClientCatalogProducts c WHERE c.clientCatalogID = :clientCatalogID")
    , @NamedQuery(name = "ClientCatalogProducts.findByClientID", query = "SELECT c FROM ClientCatalogProducts c WHERE c.clientID = :clientID")
    , @NamedQuery(name = "ClientCatalogProducts.findByBranchID", query = "SELECT c FROM ClientCatalogProducts c WHERE c.branchID = :branchID")
    , @NamedQuery(name = "ClientCatalogProducts.findByClubCodeID", query = "SELECT c FROM ClientCatalogProducts c WHERE c.clubCodeID = :clubCodeID")
    , @NamedQuery(name = "ClientCatalogProducts.findByClientSplit", query = "SELECT c FROM ClientCatalogProducts c WHERE c.clientSplit = :clientSplit")
    , @NamedQuery(name = "ClientCatalogProducts.findByListPrice", query = "SELECT c FROM ClientCatalogProducts c WHERE c.listPrice = :listPrice")
    , @NamedQuery(name = "ClientCatalogProducts.findByNegotiatedPrice", query = "SELECT c FROM ClientCatalogProducts c WHERE c.negotiatedPrice = :negotiatedPrice")
    , @NamedQuery(name = "ClientCatalogProducts.findByProductDescription", query = "SELECT c FROM ClientCatalogProducts c WHERE c.productDescription = :productDescription")
    , @NamedQuery(name = "ClientCatalogProducts.findByProductGroup", query = "SELECT c FROM ClientCatalogProducts c WHERE c.productGroup = :productGroup")
    , @NamedQuery(name = "ClientCatalogProducts.findByUpcharge", query = "SELECT c FROM ClientCatalogProducts c WHERE c.upcharge = :upcharge")
    , @NamedQuery(name = "ClientCatalogProduct.findByClientBranchClubCode", query = "SELECT c FROM ClientCatalogProducts c WHERE c.clubCodeID = :clubCodeID AND c.branchID =:branchID AND c.clientID =:clientID")        
    , @NamedQuery(name = "ClientCatalogProducts.findByTaxable", query = "SELECT c FROM ClientCatalogProducts c WHERE c.taxable = :taxable")})
public class ClientCatalogProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ClientCatalogID")
    private Integer clientCatalogID;
    @Column(name = "ClientID")
    private Integer clientID;
    @Column(name = "BranchID")
    private Integer branchID;
    @Column(name = "ClubCodeID")
    private Integer clubCodeID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ClientSplit")
    private Double clientSplit;
    @Column(name = "ListPrice")
    private Double listPrice;
    @Column(name = "NegotiatedPrice")
    private Double negotiatedPrice;
    @Size(max = 45)
    @Column(name = "ProductDescription")
    private String productDescription;
    @Size(max = 45)
    @Column(name = "ProductGroup")
    private String productGroup;
    @Column(name = "Upcharge")
    private Double upcharge;
    @Column(name = "Taxable")
    private Short taxable;
    @Column(name = "HCProductID")
    private Integer HCProductID;
    @Column(name = "EffectiveDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date effectiveDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;    
    @Column(name = "ModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;  
    @Size(max = 45)
    @Column(name = "CreatedBy")
    private String createdBy;
    @Size(max = 45)
    @Column(name = "ModifiedBy")
    private String modifiedBy;    

    public ClientCatalogProducts() {
    }

    public ClientCatalogProducts(Integer clientCatalogID) {
        this.clientCatalogID = clientCatalogID;
    }

    public Integer getClientCatalogID() {
        return clientCatalogID;
    }

    public void setClientCatalogID(Integer clientCatalogID) {
        this.clientCatalogID = clientCatalogID;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public Integer getBranchID() {
        return branchID;
    }

    public void setBranchID(Integer branchID) {
        this.branchID = branchID;
    }

    public Integer getClubCodeID() {
        return clubCodeID;
    }

    public void setClubCodeID(Integer clubCodeID) {
        this.clubCodeID = clubCodeID;
    }

    public Double getClientSplit() {
        return clientSplit;
    }

    public void setClientSplit(Double clientSplit) {
        this.clientSplit = clientSplit;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getNegotiatedPrice() {
        return negotiatedPrice;
    }

    public void setNegotiatedPrice(Double negotiatedPrice) {
        this.negotiatedPrice = negotiatedPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public Double getUpcharge() {
        return upcharge;
    }

    public void setUpcharge(Double upcharge) {
        this.upcharge = upcharge;
    }

    public Short getTaxable() {
        return taxable;
    }

    public void setTaxable(Short taxable) {
        this.taxable = taxable;
    }

    public Integer getHCProductID() {
        return HCProductID;
    }

    public void setHCProductID(Integer HCProductID) {
        this.HCProductID = HCProductID;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
        hash += (clientCatalogID != null ? clientCatalogID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientCatalogProducts)) {
            return false;
        }
        ClientCatalogProducts other = (ClientCatalogProducts) object;
        if ((this.clientCatalogID == null && other.clientCatalogID != null) || (this.clientCatalogID != null && !this.clientCatalogID.equals(other.clientCatalogID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClientCatalogProducts[ clientCatalogID=" + clientCatalogID + " ]";
    }
    
}
