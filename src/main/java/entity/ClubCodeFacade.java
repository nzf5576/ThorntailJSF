/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class ClubCodeFacade extends AbstractFacade<ClubCode> {

    @PersistenceContext(unitName = "CPQPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @SuppressWarnings("unchecked")
    public List<ClubCode> getClubCodesByClientIDBranchID(Integer clientid,Integer branchid) {
        System.out.println("Getting clubcodes for clientid: "+clientid+" and branchid "+branchid);
        return em.createNamedQuery("ClubCode.findByClientIDBranchID", ClubCode.class)
                .setParameter("clientID", clientid)
                .setParameter("branchID", branchid).getResultList();
    }
    
    public ClubCodeFacade() {
        super(ClubCode.class);
    }
    
}
