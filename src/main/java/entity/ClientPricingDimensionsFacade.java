/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class ClientPricingDimensionsFacade extends AbstractFacade<ClientPricingDimensions> {

    @PersistenceContext(unitName = "CPQPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientPricingDimensionsFacade() {
        super(ClientPricingDimensions.class);
    }
    
}
