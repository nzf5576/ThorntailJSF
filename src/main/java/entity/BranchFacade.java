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
public class BranchFacade extends AbstractFacade<Branch> {

    @PersistenceContext(unitName = "CPQPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @SuppressWarnings("unchecked")
    public List<Branch> getBranchesByClientID(Integer clientid) {
        System.out.println("Getting branches for: "+clientid);
        return em.createNamedQuery("Branch.findByClientID", Branch.class).setParameter("clientID", clientid).getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Branch> getBranchesByContrcatNumber(Integer contractNumber) {
        System.out.println("Getting branches for contract: "+contractNumber);
        return em.createNamedQuery("Branch.Branch.findByContractNumber", Branch.class).setParameter("contractNumber", contractNumber).getResultList();
    }
    
    public BranchFacade() {
        super(Branch.class);
    }
    
}
