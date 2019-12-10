/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filters;

import com.managedbeans.ControllerBean;
import global.TransactionMonitor;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebFilter(urlPatterns = {"*.xhtml"})
public class GlobalInterceptor implements javax.servlet.Filter {
    @Inject
    private ControllerBean controllerBean; 
    
    @Inject
    TransactionMonitor trans;

    
     @Override
     public void  init(FilterConfig config)  throws ServletException{
      // Get init parameter 
      String testParam = config.getInitParameter("test-param"); 

      System.out.println("Test Param: " + testParam); 
      }
     
     @Override
     public void  doFilter(ServletRequest request, 
                      ServletResponse response,
                      FilterChain chain) 
                      throws java.io.IOException, ServletException {

        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            // ControllerBeanx controllerBean = (ControllerBeanx) req.getSession().getAttribute("controllerBean");
            
            //  allow user to proccede if url is login.xhtml or user logged in or user is accessing any page in //public folder
            String reqURI = req.getRequestURI();
            String ipAddress = request.getRemoteAddr();
            System.out.println("SessionID: "+controllerBean.getSessionId()+"TransactionID: "+controllerBean.getNextTransactionID()+
                    " IP: "+ ipAddress + ", Time: " + new Date().toString()+
                    ", URI: "+reqURI+"Affinity: "+controllerBean.getAffinity_name()+
                    " Agent: "+controllerBean.getAgentid()+"Customer: "+controllerBean.getCustomer_id()+"Process: "+controllerBean.getProcess_id());
            
            /*
            System.out.println("TransactionID: "+controllerBean.getNextTransactionID());  // every new transactio we get a new if
            System.out.println("IP: "+ ipAddress + ", Time: " + new Date().toString()+", URI: "+reqURI);
            System.out.println("Affinity: "+controllerBean.getAffinity_name());
            System.out.println("Agent: "+controllerBean.getAgentid());
            System.out.println("Customer: "+controllerBean.getCustomer_id());
            System.out.println("Process: "+controllerBean.getProcess_id());
            */
            //System.out.println("Is logged in: "+ controllerBean.isLoggedIn());
            
            /*
            if (ses != null )
            chain.doFilter(request, response);
            else   // user didn't log in but asking for a page that is not allowed so take user to login page
            res.sendRedirect(req.getContextPath());  // Anonymous user. Redirect to login page
            chain.doFilter(request,response);
            */
            /*
            if (controllerBean == null || !controllerBean.isLoggedIn()) {
            String contextPath = req.getContextPath();
            res.sendRedirect(contextPath + "/agent_login.xhtml");
            }
            */
            chain.doFilter(request, response);
        } catch (Exception ex) {
            Logger.getLogger(GlobalInterceptor.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
        
     @Override
        public void destroy( ){
           /* Called before the Filter instance is removed 
           from service by the web container*/
        }
}

