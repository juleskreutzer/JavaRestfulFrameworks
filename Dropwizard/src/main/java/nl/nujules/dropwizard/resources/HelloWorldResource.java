/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.nujules.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import nl.nujules.dropwizard.api.Saying;

/**
 *
 * @author juleskreutzer
 */

/*
    @Path notifies Jersey to enable an URI with the given path
    @Produces tells Jersey that the result value that will be returned will be in the given format
*/
@Path("/dropwizard-hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    
    /**
     * Remember our configuration file? This file will now be used to create a nice message.
     * @param template Format using to create the message
     * @param defaultName Default name that will be displayed in the message
     */
    public HelloWorldResource(String template, String defaultName)
    {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong(); // used for thread-safe "unique" id generation
    }
    
    /**
     * @QueryParam("name") tells Jersey to map the parameter to the name parameter
     * @param name Name that will be displayed in the message
     * @return 
     */
    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name)
    {
        // if this endpoint is called by /dropwizard-hello-world?name= than the result will be Hello, 
        final String value = String.format("Hello test!!@$, %s", name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
}
