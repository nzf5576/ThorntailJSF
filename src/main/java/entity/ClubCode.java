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
@Table(name = "ClubCode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClubCode.findAll", query = "SELECT c FROM ClubCode c")
    , @NamedQuery(name = "ClubCode.findByIdClubCode", query = "SELECT c FROM ClubCode c WHERE c.idClubCode = :idClubCode")
    , @NamedQuery(name = "ClubCode.findByClientID", query = "SELECT c FROM ClubCode c WHERE c.clientID = :clientID")
    , @NamedQuery(name = "ClubCode.findByBranchID", query = "SELECT c FROM ClubCode c WHERE c.branchID = :branchID")
    , @NamedQuery(name = "ClubCode.findByClientIDBranchID", query = "SELECT c FROM ClubCode c WHERE c.clientID = :clientID AND c.branchID = :branchID")
    , @NamedQuery(name = "ClubCode.findByClubCodecName", query = "SELECT c FROM ClubCode c WHERE c.clubCodecName = :clubCodecName")})
public class ClubCode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClubCode")
    private Integer idClubCode;
    @Column(name = "ClientID")
    private Integer clientID;
    @Column(name = "BranchID")
    private Integer branchID;
    @Size(max = 45)
    @Column(name = "ClubCodecName")
    private String clubCodecName;

    public ClubCode() {
    }

    public ClubCode(Integer idClubCode) {
        this.idClubCode = idClubCode;
    }

    public Integer getIdClubCode() {
        return idClubCode;
    }

    public void setIdClubCode(Integer idClubCode) {
        this.idClubCode = idClubCode;
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

    public String getClubCodecName() {
        return clubCodecName;
    }

    public void setClubCodecName(String clubCodecName) {
        this.clubCodecName = clubCodecName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClubCode != null ? idClubCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClubCode)) {
            return false;
        }
        ClubCode other = (ClubCode) object;
        if ((this.idClubCode == null && other.idClubCode != null) || (this.idClubCode != null && !this.idClubCode.equals(other.idClubCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClubCode[ idClubCode=" + idClubCode + " ]";
    }
    
}
