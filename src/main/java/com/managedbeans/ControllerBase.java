/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbeans;

import java.util.UUID;



public class ControllerBase {


   UUID transactionid;


    String currentTranID;
    String nextTranID;
    String sessionId; 
    String IP;     

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    
    public ControllerBase() {
        nextTranID = String.valueOf(UUID.randomUUID());
        currentTranID = nextTranID;      
    }
 
    public String getNextTransactionID() throws Exception{
        transactionid = UUID.randomUUID();
        currentTranID = String.valueOf(transactionid);
        return currentTranID;   
    }
    
    public String getCurrentTransactionID() throws Exception{
        return currentTranID;   
    }
      
   
   
}
    
