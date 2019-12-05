package org.wildfly.swarm.examples.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 * @author Ken Finnigan
 */
@Named
@RequestScoped
public class Message {
    public String say() {
        return "Hello from JSF";
    }
}
