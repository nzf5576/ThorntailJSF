/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;


import java.util.UUID;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author mike
 */
@Singleton
@Startup
public class TransactionMonitor {
    UUID transactionid;

    String currentTranID;
    String nextTranID;
    
    /* 
    On application startup get me a unique identifier
    */
    public TransactionMonitor() {
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