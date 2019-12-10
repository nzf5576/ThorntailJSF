/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbeans;


import entity.ClientPricingDimensions;
import entity.ClientPricingDimensionsDomainValues;
import entity.ClientPricingDimensionsDomainValuesFacade;
import entity.ClientPricingDimensionsFacade;
import java.io.Serializable;
import javax.inject.Named;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;



@Named
@ViewScoped 
public class ProductAttributesControllerBean extends ControllerBase implements Serializable{
    private static final long serialVersionUID = 1L;  
    
    @Inject
    ControllerBean controllerBean;
        
    
    @EJB
    private ClientPricingDimensionsFacade clientPricingDimensionsFacade;
    private List<ClientPricingDimensions> allClientPricingDimensions;
    private ClientPricingDimensions selectedClientPricingDimension;
    private ClientPricingDimensions nextClientPricingDimension;
    
    @EJB
    private ClientPricingDimensionsDomainValuesFacade clientPricingDimensionsDomainValuesFacade;
    private List<ClientPricingDimensionsDomainValues> allClientPricingDimensionsDomainValues;
    private ClientPricingDimensionsDomainValues selectedClientPricingDimensionsDomainValue;
    private ClientPricingDimensionsDomainValues nextClientPricingDimensionsDomainValue;
    
    private String search_criteria; 
    
    
    private String searchCriteria; 
    private Integer hits=0;    

    
    public ProductAttributesControllerBean() {
    }

    public void addClientPricingDimension() { 
        clientPricingDimensionsFacade.create(this.nextClientPricingDimension);
        this.selectedClientPricingDimension=this.nextClientPricingDimension;
        this.allClientPricingDimensionsDomainValues=null;
        this.selectedClientPricingDimensionsDomainValue=null;
        this.loadClientPricingDimensions();
    }

    public void removeClientPricingDimensions(ClientPricingDimensions one) { 
        clientPricingDimensionsFacade.remove(one); 
        this.selectedClientPricingDimension=null;  
        this.allClientPricingDimensionsDomainValues=null;
        this.selectedClientPricingDimensionsDomainValue=null;
        this.loadClientPricingDimensions();
    } 
    
    public void provisionDimension() { 
        this.nextClientPricingDimension = new ClientPricingDimensions();
        System.out.println("Just provisioned for new Dimension");
    }
    
    public void updateClientPricingDimensions(ClientPricingDimensions one) {  
        clientPricingDimensionsFacade.edit(one); 
        this.loadClientPricingDimensions();
    } 
  
    @PostConstruct
    public void loadClientPricingDimensions() {      
        this.allClientPricingDimensions = clientPricingDimensionsFacade.findAll();    
    }
    
    
    public void addClientPricingDimensionsDomainValues() { 
//        ClientPricingDimensionsDomainValues cpd = new ClientPricingDimensionsDomainValues();
//        clientPricingDimensionsDomainValuesFacade.create(cpd);
//        this.selectedClientPricingDimensionsDomainValue=cpd;
//        this.loadClientPricingDimensions();
        this.nextClientPricingDimensionsDomainValue.setClientPricingDimensionsID(this.selectedClientPricingDimension.getClientPricingDimensionsID());
        clientPricingDimensionsDomainValuesFacade.create(this.nextClientPricingDimensionsDomainValue);
        this.selectedClientPricingDimensionsDomainValue=this.nextClientPricingDimensionsDomainValue;
        this.loadClientPricingDimensionsDomainValuesByDomainID();
    }

    public void removeClientPricingDimensionsDomainValues(ClientPricingDimensionsDomainValues one) { 
        clientPricingDimensionsDomainValuesFacade.remove(one); // if we remoev the role, we need to remove the teh worke role maps
        this.loadClientPricingDimensionsDomainValuesByDomainID();
    } 
  
    public void updateClientPricingDimensionsDomainValue(ClientPricingDimensionsDomainValues one) {  
        clientPricingDimensionsDomainValuesFacade.edit(one); 
    } 
        
    public void loadClientPricingDimensionsDomainValuesByDomainID() {      
        this.allClientPricingDimensionsDomainValues = clientPricingDimensionsDomainValuesFacade.getPricingDomainValuesByDimensionID(this.selectedClientPricingDimension.getClientPricingDimensionsID());
    }
    
    public void provisionDimensionDomainValues() { 
        this.nextClientPricingDimensionsDomainValue = new ClientPricingDimensionsDomainValues();
        System.out.println("Just provisioned for new Domain Values");
    }
    
    
    public void onPricingDimensionEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();       
        System.out.println("Pricing Dimension :"+newValue);
    }
    
    public void onPricingDimensionDomainValueEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();       
        System.out.println("Pricing Domain Value :"+newValue);
    }

    public void onEditLabel(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {
            DataTable s = (DataTable) event.getSource();
           // MyEntity d = (MyEntity) s.getRowData();

        }
    } 
    
        
    /**********************************************
     * 
     *             Getters and Setters
     * 
     **********************************************/
    

    public ControllerBean getControllerBean() {
        return controllerBean;
    }
    
    

    public ClientPricingDimensions getSelectedClientPricingDimension() {
        return selectedClientPricingDimension;
    }

    public void setSelectedClientPricingDimension(ClientPricingDimensions selectedClientPricingDimension) {
        this.selectedClientPricingDimension = selectedClientPricingDimension;
    }

    public ClientPricingDimensions getNextClientPricingDimension() {
        return nextClientPricingDimension;
    }

    public void setNextClientPricingDimension(ClientPricingDimensions nextClientPricingDimension) {
        this.nextClientPricingDimension = nextClientPricingDimension;
    }

    public ClientPricingDimensionsDomainValues getSelectedClientPricingDimensionsDomainValue() {
        return selectedClientPricingDimensionsDomainValue;
    }

    public void setSelectedClientPricingDimensionsDomainValue(ClientPricingDimensionsDomainValues selectedClientPricingDimensionsDomainValue) {
        this.selectedClientPricingDimensionsDomainValue = selectedClientPricingDimensionsDomainValue;
    }

    public ClientPricingDimensionsDomainValues getNextClientPricingDimensionsDomainValue() {
        return nextClientPricingDimensionsDomainValue;
    }

    public void setNextClientPricingDimensionsDomainValue(ClientPricingDimensionsDomainValues nextClientPricingDimensionsDomainValue) {
        this.nextClientPricingDimensionsDomainValue = nextClientPricingDimensionsDomainValue;
    }
    
    

    public void setControllerBean(ControllerBean controllerBean) {
        this.controllerBean = controllerBean;
    }

    public ClientPricingDimensionsDomainValuesFacade getClientPricingDimensionsDomainValuesFacade() {
        return clientPricingDimensionsDomainValuesFacade;
    }

    public void setClientPricingDimensionsDomainValuesFacade(ClientPricingDimensionsDomainValuesFacade clientPricingDimensionsDomainValuesFacade) {
        this.clientPricingDimensionsDomainValuesFacade = clientPricingDimensionsDomainValuesFacade;
    }

    public List<ClientPricingDimensionsDomainValues> getAllClientPricingDimensionsDomainValues() {
        return allClientPricingDimensionsDomainValues;
    }

    public void setAllClientPricingDimensionsDomainValues(List<ClientPricingDimensionsDomainValues> allClientPricingDimensionsDomainValues) {
        this.allClientPricingDimensionsDomainValues = allClientPricingDimensionsDomainValues;
    }

    public ClientPricingDimensionsDomainValues getSelectedClientPricingDimensionsDomainValues() {
        return selectedClientPricingDimensionsDomainValue;
    }

    public void setSelectedClientPricingDimensionsDomainValues(ClientPricingDimensionsDomainValues selectedClientPricingDimensionsDomainValue) {
        this.selectedClientPricingDimensionsDomainValue = selectedClientPricingDimensionsDomainValue;
    }

    
    
    public ClientPricingDimensionsFacade getClientPricingDimensionsFacade() {
        return clientPricingDimensionsFacade;
    }

    public void setClientPricingDimensionsFacade(ClientPricingDimensionsFacade clientPricingDimensionsFacade) {
        this.clientPricingDimensionsFacade = clientPricingDimensionsFacade;
    }

    public List<ClientPricingDimensions> getAllClientPricingDimensions() {
        return allClientPricingDimensions;
    }

    public void setAllClientPricingDimensions(List<ClientPricingDimensions> allClientPricingDimensions) {
        this.allClientPricingDimensions = allClientPricingDimensions;
    }

    public ClientPricingDimensions getSelectedClientPricingDimensions() {
        return selectedClientPricingDimension;
    }

    public void setSelectedClientPricingDimensions(ClientPricingDimensions selectedClientPricingDimension) {
        this.selectedClientPricingDimension = selectedClientPricingDimension;
    }    
    
    public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public String getSearch_criteria() {
        return search_criteria;
    }

    public void setSearch_criteria(String search_criteria) {
        this.search_criteria = search_criteria;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    
}
    
