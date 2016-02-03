/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.nujules.dropwizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author juleskreutzer
 */
public class Saying {
    private long id;
    
    @Length(max=3)
    private String content;
    
    public Saying()
    {
        // Jackson Deserialization
    }
    
    public Saying(long id, String content)
    {
        this.id = id;
        this.content = content;
    }
    
    @JsonProperty
    public long getId()
    {
        return this.id;
    }
    
    @JsonProperty
    public String getContent()
    {
        return this.content;
    }
    
}
