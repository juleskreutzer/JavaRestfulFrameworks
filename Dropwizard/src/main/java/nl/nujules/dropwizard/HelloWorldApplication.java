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
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.nujules.dropwizard.api.Saying;
import nl.nujules.dropwizard.resources.HelloWorldResource;
import nl.nujules.dropwizard.resources.PostGetExample;
import org.eclipse.jetty.server.Server;

/**
 *
 * @author juleskreutzer
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    private static Server s;
    public static void main(String[] args) throws Exception {
        // Configure the application
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable(){ 
            @Override
            public void run() {
                try {
                    shutDown();
                } catch (Exception ex) {
                    Logger.getLogger(HelloWorldApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }));
        new HelloWorldApplication().run(args);
    }
    
    private static void shutDown() throws Exception
    {
        if(s != null)
        {
            s.stop();
        }
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
        environment.lifecycle().addServerLifecycleListener(new ServerLifecycleListener() {
            @Override
            public void serverStarted(Server server) {
                s = server;
            }
        });
        final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
        final PostGetExample pge = new PostGetExample();
        
        environment.jersey().register(resource);
        environment.jersey().register(pge);
    }
    
}
