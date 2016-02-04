/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.nujules.spark;

import spark.ResponseTransformer;
import com.google.gson.*;

/**
 *
 * @author juleskreutzer
 */
public class transformer implements ResponseTransformer {

    private Gson gson = new Gson();
    
    @Override
    public String render(Object model) throws Exception {
        return gson.toJson(model);
    }
    
}
