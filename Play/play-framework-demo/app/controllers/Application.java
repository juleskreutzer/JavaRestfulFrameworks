package controllers;

import play.*;
import play.mvc.*;

import play.twirl.api.Content;
import views.html.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application extends Controller {

    private ArrayList<String> userlist = new ArrayList<>();

    public Result index() {
        response().setContentType("text/html");
        response().setHeader(CACHE_CONTROL, "no-cache");
        response().setHeader("Access-Control-Allow-Origin", "*");
        return ok("Hello World");
    }

    public Result getUsers(){
        response().setContentType("text/html");
        response().setHeader(CACHE_CONTROL, "no-cache");
        response().setHeader("Access-Control-Allow-Origin", "*");
        return ok(Arrays.toString(userlist.toArray()));
    }

    public Result addUser(String user){
        response().setContentType("text/html");
        response().setHeader(CACHE_CONTROL, "no-cache");
        response().setHeader("Access-Control-Allow-Origin", "*");
        userlist.add(user);
        return ok("User added: "+user);
    }

}
