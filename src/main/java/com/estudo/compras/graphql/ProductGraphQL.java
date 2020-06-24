package com.estudo.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.estudo.compras.entitie.Produto;
import com.estudo.compras.entitie.ProdutoInput;
import com.estudo.compras.graphql.service.ProductService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class ProductGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

  @Autowired
  ProductService productService;

  public Produto product(Long id){
    return productService.findById(id);
  }

  public List<Produto> products(){
    return productService.findAll();
  }

  public Produto saveProduct(ProdutoInput input){
    ModelMapper mapper = new ModelMapper();
    Produto produto = mapper.map(input, Produto.class);
    return productService.save(produto);
  }

  public Boolean deleteProduct(Long id){
    return productService.deleteById(id);
  }
}
