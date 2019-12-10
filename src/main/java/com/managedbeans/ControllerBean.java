/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbeans;


import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import global.AppGlobal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;




@Named
@SessionScoped
public class ControllerBean extends ControllerBase implements Serializable{
    private static final long serialVersionUID = 1L;  
    
    @Inject
    AppGlobal appg;
       


    private List<String> queues;  // queues that the perosn logged in can work; this stores the queueSID
     
    private Integer hits=0;
    private String search;
    String loginId;
    private String loginPass;
    private String logintemp;
    private String logintemphone;
    private String response;
    private String nextAction;
    private Integer attempts=0;
    private long outstandingworkitemcount;
    private String agentid;  //this always tells me who the agent logged in
    private String customer_id;  //this is teh ssn of the perosn with the current focus.
    private String affinity_id; // thsi si the id of the affinity
    private String affinity_name; // thsi si the id of the affinity
    private String process_id; // the current application in focus

    private String view="agent_main";  //agent_main or fullmain
    private Boolean reload_flag=true;



    public long getOutstandingworkitemcount() {
        return outstandingworkitemcount;
    }

    public void setOutstandingworkitemcount(long outstandingworkitemcount) {
        this.outstandingworkitemcount = outstandingworkitemcount;
    }   
    
    public Boolean getReload_flag() {
        return reload_flag;
    }

    public void setReload_flag(Boolean reload_flag) {
        this.reload_flag = reload_flag;
    }

    public String getAffinity_name() {
        return affinity_name;
    }

    public void setAffinity_name(String affinity_name) {
        this.affinity_name = affinity_name;
    }
    
    
    
    public void changeView(){
        if("agent_main".equals(this.view)){
            view="agent_mainw";
        } else{
            view="agent_main";
        }   
    }
    
    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getAffinity_id() {
        return affinity_id;
    }

    public void setAffinity_id(String affinity_id) {
        this.affinity_id = affinity_id;
    }

    public String getProcess_id() {
        return process_id;
    }

    public void setProcess_id(String process_id) {
        this.process_id = process_id;
    }

    public ControllerBean() {
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getLogintemphone() {
        return logintemphone;
    }

    public void setLogintemphone(String logintemphone) {
        this.logintemphone = logintemphone;
    }

    public String getLogintemp() {
        return logintemp;
    }

    public void setLogintemp(String logintemp) {
        this.logintemp = logintemp;
    }
    
    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
     
    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

      
    public String nextAction() { 
        return nextAction; 
    }
    
    
    public void setNextAction(String action) { 
        this.nextAction = action; 
    }    
    
    public void openGlobalSetup() { 
        this.nextAction = "global_setup";
    }
    
    public void openClientSetup() { 
        this.nextAction = "client_setup";
    }
    
    public void openClientPricing() { 
        this.nextAction = "client_pricing_config";
    }


        
  
            
    
    public String logOut()throws Exception{
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
        if(httpSession!=null){
            httpSession.invalidate();
          }
        return "/agent_login.xhtml?faces-redirect=true";
    }
    
    public void isAdmin(ComponentSystemEvent event){
				
	FacesContext fc = FacesContext.getCurrentInstance();
		
	if (!"admin".equals(fc.getExternalContext().getSessionMap().get("role"))){

		ConfigurableNavigationHandler nav 
		   = (ConfigurableNavigationHandler) 
			fc.getApplication().getNavigationHandler();
		
		nav.performNavigation("access-denied");
	}		
    }	
  
    public String checkLogin() {
        //FacesContext context = FacesContext.getCurrentInstance();
        //HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        System.out.println("looking for.. "+loginId);

        if (loginId.equals("0000")){  //0 means the strinsg are equal therefire it is a true statement 
                System.out.println("sucessfully logged in "+loginId);
                this.agentid=this.loginId; //  this is how i track which agent is logged in.  right now loginId is the agnetid, but thsi can change

                //Next we get the session id so we can display it on the screen
                FacesContext fCtx = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
                super.setSessionId(session.getId()); // sessionid in super class
                super.setIP(appg.ip.getHostAddress());
                appg.usersessions.put(this.loginId, session.getId());
                Set set = appg.usersessions.entrySet();
                Iterator iterator = set.iterator();
                while(iterator.hasNext()) {
                   Map.Entry mentry = (Map.Entry)iterator.next();
                   System.out.println("Agent Id is: "+ mentry.getKey() + "  SessionID: "+mentry.getValue());
                }

                this.openGlobalSetup();
                this.setView("agent_main");
            }
            else {       
                System.out.println("ok i entered bad login info"+loginId);
                setNextAction("agent_login");
                this.attempts++;
                this.setView("agent_login"); 
            /* if(this.attempts.compareTo(5)==0){
            session.invalidate();*/
        }
  
    return this.view;
    }  
        
     
    public void resetLogin() {
    FacesContext context = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);        
    session.invalidate();
    }
    


}
    
