package com.estudo.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.estudo.compras.entitie.Produto;
import com.estudo.compras.entitie.ProdutoInput;
import com.estudo.compras.graphql.service.ProdutoService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

  @Autowired
  private ProdutoService service;

  public Produto produto(Long id) {
    return service.findById(id);
  }

  public List<Produto> produtos() {
    return service.findAll();
  }

  public Produto saveProduto(ProdutoInput input) {
    ModelMapper m = new ModelMapper();
    Produto c = m.map(input,Produto.class);

    return service.save(c);
  }

  public Boolean deleteProduto(Long id) {
    return service.deleteById(id);
  }
}
