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
public class ClientCatalogProductsFacade extends AbstractFacade<ClientCatalogProducts> {

    @PersistenceContext(unitName = "CPQPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientCatalogProductsFacade() {
        super(ClientCatalogProducts.class);
    }
    
    @SuppressWarnings("unchecked")
    public List<ClientCatalogProducts> getCatalogProductsByClientIDBranchIDClubCodeID(Integer clientid, Integer branchid, Integer clubcodeid) {
        System.out.println("Getting Products for: "+branchid);
        return em.createNamedQuery("ClientCatalogProduct.findByClientBranchClubCode", ClientCatalogProducts.class)
                .setParameter("clientID", clientid)
                .setParameter("branchID", branchid)
                .setParameter("clubCodeID", clubcodeid).getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public ClientCatalogProducts getCatalogProductsByCatalogID(Integer catalogid) {
        System.out.println("Getting Products for: "+catalogid);
        return em.createNamedQuery("ClientCatalogProducts.findByClientCatalogID", ClientCatalogProducts.class)
                .setParameter("clientCatalogID", catalogid)
                .getSingleResult();
    }
 
    
}
