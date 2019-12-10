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
@Table(name = "HCProductCatalogReference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HCProductCatalogReference.findAll", query = "SELECT h FROM HCProductCatalogReference h")
    , @NamedQuery(name = "HCProductCatalogReference.findByIdProductCatalog", query = "SELECT h FROM HCProductCatalogReference h WHERE h.idProductCatalog = :idProductCatalog")
    , @NamedQuery(name = "HCProductCatalogReference.findByDescription", query = "SELECT h FROM HCProductCatalogReference h WHERE h.description = :description")
    , @NamedQuery(name = "HCProductCatalogReference.findByListPrice", query = "SELECT h FROM HCProductCatalogReference h WHERE h.listPrice = :listPrice")
    , @NamedQuery(name = "HCProductCatalogReference.findByProductCatalog", query = "SELECT h FROM HCProductCatalogReference h WHERE h.productCatalog = :productCatalog")
    , @NamedQuery(name = "HCProductCatalogReference.findByProductGroup", query = "SELECT h FROM HCProductCatalogReference h WHERE h.productGroup = :productGroup")})
public class HCProductCatalogReference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProductCatalog")
    private Integer idProductCatalog;
    @Size(max = 45)
    @Column(name = "Description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ListPrice")
    private Double listPrice;
    @Size(max = 45)
    @Column(name = "ProductCatalog")
    private String productCatalog;
    @Size(max = 45)
    @Column(name = "ProductGroup")
    private String productGroup;


    public HCProductCatalogReference() {
    }

    public HCProductCatalogReference(Integer idProductCatalog) {
        this.idProductCatalog = idProductCatalog;
    }

    public Integer getIdProductCatalog() {
        return idProductCatalog;
    }

    public void setIdProductCatalog(Integer idProductCatalog) {
        this.idProductCatalog = idProductCatalog;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public String getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(String productCatalog) {
        this.productCatalog = productCatalog;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductCatalog != null ? idProductCatalog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HCProductCatalogReference)) {
            return false;
        }
        HCProductCatalogReference other = (HCProductCatalogReference) object;
        if ((this.idProductCatalog == null && other.idProductCatalog != null) || (this.idProductCatalog != null && !this.idProductCatalog.equals(other.idProductCatalog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.HCProductCatalogReference[ idProductCatalog=" + idProductCatalog + " ]";
    }
    
}
