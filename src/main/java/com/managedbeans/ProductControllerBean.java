/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbeans;


import entity.Client;
import entity.ClientCatalogProducts;
import entity.ClientCatalogProductsFacade;
import entity.ClientFacade;
import entity.ClientPricingDimensions;
import entity.ClientPricingDimensionsFacade;
import entity.HCProductCatalogReference;
import entity.HCProductCatalogReferenceFacade;
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
public class ProductControllerBean extends ControllerBase implements Serializable{
    private static final long serialVersionUID = 1L;  
    
    @Inject
    ControllerBean controllerBean;
        
    @EJB
    private ClientFacade clientFacade;
    private List<Client> allClients;
    private Client selectedClient;
    
    @EJB
    private ClientPricingDimensionsFacade clientPricingDimensionsFacade;
    private List<ClientPricingDimensions> allClientPricingDimensions;
    private ClientPricingDimensions selectedClientPricingDimensions;


    @EJB
    private HCProductCatalogReferenceFacade hcProductCatalogReferenceFacade;
    private List<HCProductCatalogReference> allHCProductCatalogReference;
    private HCProductCatalogReference selectedHCProductCatalogReference;

    @EJB
    private ClientCatalogProductsFacade clientCatalogProductsFacade;
    private List<ClientCatalogProducts> allClientCatalogProducts;
    private ClientCatalogProducts selectedClientCatalogProducts;
    
    
    private String search_criteria; 
    
    
    private String searchCriteria; 
    private Integer hits=0;    

    
    public ProductControllerBean() {
    }


    
    
    public void addClientPricingDimensions() { 
        ClientPricingDimensions cpd = new ClientPricingDimensions();
        clientPricingDimensionsFacade.create(cpd);
        this.selectedClientPricingDimensions=cpd;
//        this.loadClientPricingDimensions();
    }

    public void removeClientPricingDimensions(ClientPricingDimensions one) { 
        clientPricingDimensionsFacade.remove(one); // if we remoev the role, we need to remove the teh worke role maps
     //   this.loadRoles();
    } 
  
    public void loadClientPricingDimensions() {      
        this.allClientPricingDimensions = clientPricingDimensionsFacade.findAll();    
    }
       
    
    @PostConstruct
    public void loadClients() { 
        this.allClients = clientFacade.findAll();
    }
    
  
    public void onRoleEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue(); 
        System.out.println("Role :"+newValue);
    }
    
    public void onQueueEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        System.out.println("Queue :"+newValue);
    }
    
    public void onQueueRoleEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();       
        System.out.println("QueueRole :"+newValue);
    }
    
    public void onWorkerRoleEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();        
        System.out.println("WorkerRole :"+newValue);
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

    public void setControllerBean(ControllerBean controllerBean) {
        this.controllerBean = controllerBean;
    }

    public ClientFacade getClientFacade() {
        return clientFacade;
    }

    public void setClientFacade(ClientFacade clientFacade) {
        this.clientFacade = clientFacade;
    }

    public List<Client> getAllClients() {
        return allClients;
    }

    public void setAllClients(List<Client> allClients) {
        this.allClients = allClients;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
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
        return selectedClientPricingDimensions;
    }

    public void setSelectedClientPricingDimensions(ClientPricingDimensions selectedClientPricingDimensions) {
        this.selectedClientPricingDimensions = selectedClientPricingDimensions;
    }


    public HCProductCatalogReferenceFacade getHcProductCatalogReferenceFacade() {
        return hcProductCatalogReferenceFacade;
    }

    public void setHcProductCatalogReferenceFacade(HCProductCatalogReferenceFacade hcProductCatalogReferenceFacade) {
        this.hcProductCatalogReferenceFacade = hcProductCatalogReferenceFacade;
    }

    public List<HCProductCatalogReference> getAllHCProductCatalogReference() {
        return allHCProductCatalogReference;
    }

    public void setAllHCProductCatalogReference(List<HCProductCatalogReference> allHCProductCatalogReference) {
        this.allHCProductCatalogReference = allHCProductCatalogReference;
    }

    public HCProductCatalogReference getSelectedHCProductCatalogReference() {
        return selectedHCProductCatalogReference;
    }

    public void setSelectedHCProductCatalogReference(HCProductCatalogReference selectedHCProductCatalogReference) {
        this.selectedHCProductCatalogReference = selectedHCProductCatalogReference;
    }

    public ClientCatalogProductsFacade getClientCatalogProductsFacade() {
        return clientCatalogProductsFacade;
    }

    public void setClientCatalogProductsFacade(ClientCatalogProductsFacade clientCatalogProductsFacade) {
        this.clientCatalogProductsFacade = clientCatalogProductsFacade;
    }

    public List<ClientCatalogProducts> getAllClientCatalogProducts() {
        return allClientCatalogProducts;
    }

    public void setAllClientCatalogProducts(List<ClientCatalogProducts> allClientCatalogProducts) {
        this.allClientCatalogProducts = allClientCatalogProducts;
    }

    public ClientCatalogProducts getSelectedClientCatalogProducts() {
        return selectedClientCatalogProducts;
    }

    public void setSelectedClientCatalogProducts(ClientCatalogProducts selectedClientCatalogProducts) {
        this.selectedClientCatalogProducts = selectedClientCatalogProducts;
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
    
