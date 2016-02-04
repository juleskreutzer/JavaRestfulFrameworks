/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.nujules.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.lifecycle.ServerLifecycleListener;
import io.dropwizard.server.ServerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import nl.nujules.dropwizard.api.Saying;
import nl.nujules.dropwizard.resources.HelloWorldResource;
import nl.nujules.dropwizard.resources.PostGetExample;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.eclipse.jetty.util.Jetty;

/**
 *
 * @author juleskreutzer
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    
    /**
     * IMPORTANT: When this program is first executed, a Jetty Server will be started. 
     * This server will not be shut down then this program is closed resulting in a bindException when running
     * this program again.
     * 
     * To stop the Jetty server using the command line:
     * 1. run the command "jps"
     * 2. Remember the number before "HelloWorldApplication". This is your PID
     * 3. run the command "kill -9 {PID}" (replace PID)
     * 
     * You can now run this application again without any error.
     * 
     */

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }
    
    @Override
    public String getName()
    {
        return "Hello-world";
    }
    
    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> boostrap) 
    {
        
    }
    
    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {
        
        final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
        final PostGetExample pge = new PostGetExample();
        
        environment.jersey().register(resource);
        environment.jersey().register(pge);
        
        // Add a filter for Access-Control-Allow-Origin
        
        final FilterRegistration.Dynamic cors =
        environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("Access-Control-Allow-Origin", "*");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        
    }
}
