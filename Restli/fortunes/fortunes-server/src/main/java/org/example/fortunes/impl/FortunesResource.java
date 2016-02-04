package org.example.fortunes.impl;

import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import org.example.fortunes.Fortune;

@RestLiCollection(name = "fortunes", namespace = "org.example.fortunes")
public class FortunesResource extends CollectionResourceTemplate<Long, Fortune>
{
  @Override
  public String get(Long key) { return new String("Hello, test"); }

//  @Override
//  public Fortune get(Long key)
//  {
//    return new Fortune().setMessage("Hello, Rest.li!");
//  }
}
