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
@Table(name = "Branch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b")
    , @NamedQuery(name = "Branch.findByIdBranch", query = "SELECT b FROM Branch b WHERE b.idBranch = :idBranch")
    , @NamedQuery(name = "Branch.findByClientID", query = "SELECT b FROM Branch b WHERE b.clientID = :clientID")
    , @NamedQuery(name = "Branch.findByTransitRoutingNumber", query = "SELECT b FROM Branch b WHERE b.transitRoutingNumber = :transitRoutingNumber")
    , @NamedQuery(name = "Branch.findByContractNumber", query = "SELECT b FROM Branch b WHERE b.contractNumber = :contractNumber")
    , @NamedQuery(name = "Branch.findByBranchNumber", query = "SELECT b FROM Branch b WHERE b.branchNumber = :branchNumber")})
public class Branch implements Serializable {



    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBranch")
    private Integer idBranch;
    @Column(name = "ClientID")
    private Integer clientID;
    @Size(max = 45)
    @Column(name = "BranchNumber")
    private String branchNumber;
    @Size(max = 45)
    @Column(name = "TransitRoutingNumber")
    private String transitRoutingNumber;
    @Size(max = 25)
    @Column(name = "ContractNumber")
    private String contractNumber;


    public Branch() {
    }

    public Branch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(String branchNumber) {
        this.branchNumber = branchNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBranch != null ? idBranch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.idBranch == null && other.idBranch != null) || (this.idBranch != null && !this.idBranch.equals(other.idBranch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Branch[ idBranch=" + idBranch + " ]";
    }

    public String getTransitRoutingNumber() {
        return transitRoutingNumber;
    }

    public void setTransitRoutingNumber(String transitRoutingNumber) {
        this.transitRoutingNumber = transitRoutingNumber;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }
    
}
