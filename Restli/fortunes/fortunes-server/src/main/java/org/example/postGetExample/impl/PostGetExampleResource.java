package org.example.postGetExample.impl;

import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import org.example.postGetExample.PostGetExample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juleskreutzer on 05-02-16.
 */
@RestLiCollection(name="postGetExample", namespace = "org.example.postGetExample")
public class PostGetExampleResource extends CollectionResourceTemplate<Long, PostGetExample> {

    @Override
    public PostGetExample get(Long key)
    {
        return new PostGetExample();
    }
}
