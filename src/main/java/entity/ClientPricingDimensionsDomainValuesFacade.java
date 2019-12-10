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
public class ClientPricingDimensionsDomainValuesFacade extends AbstractFacade<ClientPricingDimensionsDomainValues> {

    @PersistenceContext(unitName = "CPQPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientPricingDimensionsDomainValuesFacade() {
        super(ClientPricingDimensionsDomainValues.class);
    }
    
    @SuppressWarnings("unchecked")
    public List<ClientPricingDimensionsDomainValues> getPricingDomainValuesByDimensionID(Integer dimensionid) {
    System.out.println("Getting Products for: "+dimensionid);
    return em.createNamedQuery("ClientPricingDimensionsDomainValues.findByClientPricingDimensionsID", ClientPricingDimensionsDomainValues.class)
            .setParameter("clientPricingDimensionsID", dimensionid).getResultList();
    }
    
}
