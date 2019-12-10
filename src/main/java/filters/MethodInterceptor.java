/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;


public class MethodInterceptor implements Serializable{
 //       @Inject
 //       ControllerBean controllerBean;
//         @Resource
//         private SessionContext sessioncontext;

	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
                //System.out.println("Controller TransactionID :"+base.getTransactionID());
		//System.out.println("TRANSID: "+context.getClass().getDeclaredField("currentTranID")+" BEAN: "+context.getMethod().getDeclaringClass().getName()+" METHOD: "+context.getMethod().getName() );

               
                /*
                FacesContext fCtx = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
                String sessionId = session.getId();
                if(sessionId == null){
                    System.out.println("SESSION : 0000  BEAN: "+context.getMethod().getDeclaringClass().getName()+" METHOD: "+context.getMethod().getName() );
                }
                else
                {
                   System.out.println("SESSION : "+sessionId+" BEAN: "+context.getMethod().getDeclaringClass().getName()+" METHOD: "+context.getMethod().getName() );
                }
                    **/    
          
                //System.out.println(" #AUTH : "+context.getConstructor().getClass().);
               //Object ctxParam = context.getContextData().get(ctxParamKey);
		//System.out.println("TRAN: "+ctxParam);
              // String currentUser = sessioncontext.getCallerPrincipal().getName();
               //System.out.println("TRAN: "+sessioncontext.);
               /* 
               
               System.out.println(" #FIELDS : "+context.getClass().getDeclaredFields().length); 
               for (Object object : context.getClass().getDeclaredFields()) {
                        object.getClass().getName();
			System.out.println("FIELD NAME: "+object);


                    }
                                 
                if (context.getParameters() != null) {
		for (Object object : context.getParameters()) {
			object.getClass().getName();
                        System.out.println(" PARMS: "+object);

                    }

                }*/
                
          
                long start = System.currentTimeMillis();
		Object result = context.proceed();
                
                long executionTime = System.currentTimeMillis() - start;
                //System.out.println("Transaction:"+trans.getCurrentTransactionID()+"POST-Method:"+context.getMethod().getName() );
                System.out.println("Execution Time(ms): "+executionTime+" BEAN: "+context.getMethod().getDeclaringClass().getName()+" METHOD: "+context.getMethod().getName());

		return result;
	}
}