/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.nujules.dropwizard;

import nl.nujules.dropwizard.Saying;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
import eu.agilejava.snoop.annotation.Snoop;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import eu.agilejava.snoop.*;

/**
 *
 * @author juleskreutzer
 */


@Path("/dropwizard-hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    
    @Inject
    @Snoop(serviceName="dropwizard-hello-world")
    private SnoopDiscoveryClient helloService;
    
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
    
}
