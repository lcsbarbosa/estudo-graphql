package com.estudo.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.estudo.compras.entitie.Produto;
import com.estudo.compras.graphql.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductGraphQL implements GraphQLQueryResolver {

  @Autowired
  ProductService productService;

  public Produto product(Long id){
    return productService.findById(id);
  }

  public List<Produto> produts(){
    return productService.findAll();
  }
}
