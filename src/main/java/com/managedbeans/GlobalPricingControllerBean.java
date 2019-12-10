/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbeans;


import entity.Branch;
import entity.BranchFacade;
import entity.Client;
import entity.ClientCatalogProducts;
import entity.ClientCatalogProductsFacade;
import entity.ClientFacade;
import entity.ClubCode;
import entity.ClubCodeFacade;
import entity.HCProductCatalogReference;
import entity.HCProductCatalogReferenceFacade;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
public class GlobalPricingControllerBean extends ControllerBase implements Serializable{
    private static final long serialVersionUID = 1L;  
    
    @Inject
    ControllerBean controllerBean;
        
    @EJB
    private ClientFacade clientFacade;
    private List<Client> allClients;
    private Client selectedClient;
    private Client nextClient;

    @EJB
    private BranchFacade branchFacade;
    private List<Branch> allBranches;
    private Branch selectedBranch;
    private Branch nextBranch;

    @EJB
    private ClubCodeFacade clubCodeFacade;
    private List<ClubCode> allClubCodes;
    private ClubCode selectedClubCode;
    private ClubCode nextClubCode;

    @EJB
    private ClientCatalogProductsFacade clientCatalogProductsFacade;
    private List<ClientCatalogProducts> allClientCatalogProducts;
    private ClientCatalogProducts selectedClientCatalogProduct;
    private ClientCatalogProducts nextClientCatalogProduct;
    
    @EJB
    private HCProductCatalogReferenceFacade hcProductCatalogReferenceFacade;
    private List<HCProductCatalogReference> allHCProductCatalogReference;
    private HCProductCatalogReference selectedHCProductCatalogReference;

    
    private String search_criteria; 
    
    
    private String searchCriteria; 
    private Integer hits=0;    

    
    public GlobalPricingControllerBean() {
    }
    
    public void provisionClient() { 
        this.nextClient = new Client();
    }
        
    public void addClient() { 
        clientFacade.create(this.nextClient);
        this.selectedClient=this.nextClient;
        this.loadClients();
    } 
    
    @PostConstruct
    public void loadClients() {      
        this.allClients = clientFacade.findAll();
        System.out.println("Found Clients#: "+this.allClients.size());
        this.allHCProductCatalogReference = hcProductCatalogReferenceFacade.findAll();
        this.allBranches = null;
        this.selectedBranch =null;
        this.allClubCodes = null;
        this.selectedClubCode = null;
        this.allClientCatalogProducts = null;
    }
    
    public void loadBranches() {      
        this.allBranches = branchFacade.getBranchesByClientID(this.selectedClient.getClientID());   
        System.out.println("Found Branches#: "+this.allBranches.size());
        this.allClubCodes = null;
        this.selectedClubCode = null;
        this.selectedBranch = null;
        this.allClientCatalogProducts = null;
        //loadClientProducts();
    }
    
    public void loadClubCodes() {      
        this.allClubCodes = clubCodeFacade.getClubCodesByClientIDBranchID(this.selectedClient.getClientID(),this.selectedBranch.getIdBranch());
        this.selectedClubCode = null;
        this.allClientCatalogProducts = null;
        System.out.println("Found ClubCodes#: "+this.allClubCodes.size());
    }
    
    public void loadClientProducts() {      
        this.allClientCatalogProducts = clientCatalogProductsFacade.getCatalogProductsByClientIDBranchIDClubCodeID(this.selectedClient.getClientID(), this.selectedBranch.getIdBranch(), this.selectedClubCode.getIdClubCode());    
        System.out.println("Found Products#: "+this.allClientCatalogProducts.size());    
    }
    
    public void provisionBranch() { 
        this.nextBranch = new Branch();
        this.nextBranch.setClientID(this.selectedClient.getClientID());       
    }
    
    public void addBranch() { 
        branchFacade.create(this.nextBranch);
        this.selectedBranch=this.nextBranch;
        this.loadBranches();
    }

    public void provisionClubCode() { 
        this.nextClubCode = new ClubCode();
        this.nextClubCode.setClientID(this.selectedClient.getClientID());  
        this.nextClubCode.setBranchID(this.selectedBranch.getIdBranch()); 
    }
    
    public void addClubCode() { 
        clubCodeFacade.create(this.nextClubCode);
        this.selectedClubCode=this.nextClubCode;
        this.loadClubCodes();
    }
     
    public void addClientProduct() { 
        System.out.println("Client----------------------------->"+this.selectedClient.getClientID());
        System.out.println("Branch----------------------------->"+this.selectedBranch.getIdBranch());
        System.out.println("ClubCode----------------------------->"+this.selectedClubCode.getIdClubCode());
        //System.out.println("ClientCatalogProduct----------------------------->"+this.nextClientCatalogProduct.getProductDescription());
        ClientCatalogProducts ccp = new ClientCatalogProducts();
        ccp.setClientID(this.selectedClient.getClientID());
        ccp.setBranchID(this.selectedBranch.getIdBranch());
        ccp.setClubCodeID(this.selectedClubCode.getIdClubCode());
        ccp.setListPrice(this.selectedHCProductCatalogReference.getListPrice());
        ccp.setProductDescription(this.selectedHCProductCatalogReference.getDescription());
        ccp.setHCProductID(this.selectedHCProductCatalogReference.getIdProductCatalog());
        ccp.setProductGroup(currentTranID);

        Date today = Calendar.getInstance().getTime();
        ccp.setCreateDate(today);
        ccp.setModifiedDate(today);
        ccp.setCreatedBy(controllerBean.getLoginId());
        ccp.setModifiedBy(controllerBean.getLoginId());
        
        clientCatalogProductsFacade.create(ccp);
        this.selectedClientCatalogProduct=ccp;
        this.loadClientProducts();
    }
    
    public void updateClientProducts(ClientCatalogProducts one) { 
        Date today = Calendar.getInstance().getTime();
        one.setModifiedDate(today);
        one.setModifiedBy(controllerBean.getLoginId());
        
        clientCatalogProductsFacade.edit(one); 
        this.loadClientProducts();
    } 
    
    public void removeClientProducts(ClientCatalogProducts one) { 
        clientCatalogProductsFacade.remove(one); 
        this.loadClientProducts();
    } 

    
    public void onProductEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        System.out.println("Product :"+newValue);
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
     * @return 
     **********************************************/      

    public Client getNextClient() {
        return nextClient;
    }

    public void setNextClient(Client nextClient) {
        this.nextClient = nextClient;
    }

    public Branch getNextBranch() {
        return nextBranch;
    }

    public void setNextBranch(Branch nextBranch) {
        this.nextBranch = nextBranch;
    }

    public ClubCode getNextClubCode() {
        return nextClubCode;
    }

    public void setNextClubCode(ClubCode nextClubCode) {
        this.nextClubCode = nextClubCode;
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

    public ClientCatalogProducts getSelectedClientCatalogProduct() {
        return selectedClientCatalogProduct;
    }

    public void setSelectedClientCatalogProduct(ClientCatalogProducts selectedClientCatalogProduct) {
        this.selectedClientCatalogProduct = selectedClientCatalogProduct;
    }  

    public List<Branch> getAllBranches() {
        return allBranches;
    }

    public void setAllBranches(List<Branch> allBranches) {
        this.allBranches = allBranches;
    }

    public Branch getSelectedBranch() {
        return selectedBranch;
    }

    public void setSelectedBranch(Branch selectedBranch) {
        this.selectedBranch = selectedBranch;
    }

    public List<ClubCode> getAllClubCodes() {
        return allClubCodes;
    }

    public void setAllClubCodes(List<ClubCode> allClubCodes) {
        this.allClubCodes = allClubCodes;
    }

    public ClubCode getSelectedClubCode() {
        return selectedClubCode;
    }

    public void setSelectedClubCode(ClubCode selectedClubCode) {
        this.selectedClubCode = selectedClubCode;
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

    public ClientCatalogProducts getNextClientCatalogProduct() {
        return nextClientCatalogProduct;
    }

    public void setNextClientCatalogProduct(ClientCatalogProducts nextClientCatalogProduct) {
        this.nextClientCatalogProduct = nextClientCatalogProduct;
    }
    

    
    
}
    
