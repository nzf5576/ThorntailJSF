/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.UUID;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author mike
 */
@Singleton
@Startup
public class AppGlobal {
    
    public final String DUBUG_LEVEL="LOW"; //OFF , LOW, HIGH
    public final String RELEASE="v1.0.0"; 
    public final String FILE_PATH="/slingdoc";  
    public HashMap<String, String> usersessions = new HashMap<String, String>(); //userid, session
    public InetAddress ip;
    

      /*Adding elements to HashMap
      hmap.put("Foo", "Chaitanya");
    
     Display content using Iterator
      Set set = hmap.entrySet();
      Iterator iterator = set.iterator();
      while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
         System.out.println(mentry.getValue());
      }

       Get values based on key
      String var= hmap.get(2);
      System.out.println("Value at index 2 is: "+var);

      Remove values based on key
      hmap.remove(3);
      System.out.println("Map key and values after removal:");
      Set set2 = hmap.entrySet();
      Iterator iterator2 = set2.iterator();
      while(iterator2.hasNext()) {
          Map.Entry mentry2 = (Map.Entry)iterator2.next();
          System.out.print("Key is: "+mentry2.getKey() + " & Value is: ");
          System.out.println(mentry2.getValue());
       }
    
    */

    public AppGlobal() {
        
        // Thsi si just a test to explore ways to load properties on startup.
        
        String developer = System.getProperty("developer");
        System.out.println("SlingDoc developed by: "+developer);
        try {
            ip = InetAddress.getLocalHost();
            System.out.println("Your current IP address : " + ip);
 
        } catch (UnknownHostException e) {
        }
        
    }
    
}



