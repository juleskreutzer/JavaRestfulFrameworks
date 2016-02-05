package org.example.helloWorld.impl;

/**
 * Created by juleskreutzer on 05-02-16.
 */
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import org.example.helloWorld.HelloWorld;

@RestLiCollection(name = "helloWorld", namespace = "org.example.helloWorld")
public class HelloWorldResource extends CollectionResourceTemplate<Long, HelloWorld>
{
    @Override
    public HelloWorld get(Long key)
    {
        return new HelloWorld().setMessage("Hello, world!");
    }
}
