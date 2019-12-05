package com.managedbeans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 * @author Ken Finnigan
 */
@Named
@SessionScoped
public class ControllerMain implements Serializable{
    private static final long serialVersionUID = 1L;  
    
    String app_name="VictoryCapital";

    public ControllerMain() {
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }
    

}
