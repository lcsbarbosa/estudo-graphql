package com.estudo.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class HelloGraphQL implements GraphQLQueryResolver {

  public String hello(){
    return "Hello GraphQL";
  }
}
