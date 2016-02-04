/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.nujules.spark;

import java.util.ArrayList;
import java.util.List;
import static spark.Spark.*;

/**
 *
 * @author juleskreutzer
 */
public class Spark {
    
    public static void main(String[] args) throws Exception {
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

        // Make sure Spark runs on port 8080
        // This can give a confict when other services are running on the same port
        port(8080);
        
        /**
         * /Hello endpoint
         * @param :name name that will be showed in the result
         */
        get("/spark/hello/:name", (request, response) -> {
            response.type("application/json"); // Return JSON 
            return "Hello, " + request.params(":name");
        }, new transformer());
        
        // List containing users
        List<String> users = new ArrayList<>();
        
        //Return all users of the list
        get("/spark/post-get/", (request, response) -> {
            response.type("application/json");
            return users;
        }, new transformer());
        
        // Add a user to the list
        // Do you see the difference where we put the content type "application/json"?
        post("/spark/post-get/:name", "application/json", (request, response) -> {
            users.add(request.params(":name"));
            return "User added!";
        }, new transformer());
        
        // This will stop the Jetty Server
        post("/spark/stop", (request, response) -> {
            stop();
            return null;
        });
    }        
}
