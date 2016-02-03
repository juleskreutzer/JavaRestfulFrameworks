/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.nujules.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import io.dropwizard.jersey.params.NonEmptyStringParam;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author juleskreutzer
 */

@Path("/dropwizard-post-get")
@Produces(MediaType.APPLICATION_JSON)
public class PostGetExample {
    
    private ArrayList<String> users;
    private final String defaultName;
    
    public PostGetExample()
    {
        this.users = new ArrayList<>();
        this.defaultName = "No name provided.";
    }
    
    @POST
    public String addUser(@QueryParam("name") Optional<String> name)
    {
        this.users.add(name.or(defaultName));
        
        return "User added";
    }
    
    @GET
    @Timed
    public Object[] getAllUsers()
    {
        return users.toArray();
    }
}
