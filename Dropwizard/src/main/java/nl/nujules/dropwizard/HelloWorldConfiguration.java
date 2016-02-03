/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.nujules.dropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author juleskreutzer
 */
public class HelloWorldConfiguration extends Configuration {
    
    /**
     * The @NotEmpty annotation will make sure that the value is not null or doesn't exist in the config file.
     * When a value is empty or doesn't exist, an exception will be thrown because this class extends the Configuration-class
     */
    
    /**
     * The @JsonProperty is used by Jackson. It allows Jackson to deserialize the properties from the config file and to serialize it.
     */
    
    @NotEmpty
    private String template;
    
    @NotEmpty
    private String defaultName = "Stranger";
    
    @JsonProperty
    public String getTemplate()
    {
        return template;
    }
    
    @JsonProperty
    public void setTempalte(String template)
    {
        this.template = template;
    }
    
    @JsonProperty
    public String getDefaultName()
    {
        return defaultName;
    }
    
    @JsonProperty
    public void setDefaultName(String defaultName)
    {
        this.defaultName = defaultName;
    }
    
}
