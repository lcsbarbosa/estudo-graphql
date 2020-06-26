package com.estudo.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.estudo.compras.entitie.Compra;
import com.estudo.compras.entitie.CompraInput;
import com.estudo.compras.graphql.service.ClienteService;
import com.estudo.compras.graphql.service.CompraService;
import com.estudo.compras.graphql.service.ProdutoService;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

  @Autowired
  private CompraService service;

  @Autowired
  private ClienteService clienteService;

  @Autowired
  private ProdutoService produtoService;

  public Compra compra(Long id) {
    return service.findById(id);
  }

  public List<Compra> compras() {
    return service.findAll();
  }

  public Compra saveCompra(CompraInput input) {
    ModelMapper m = new ModelMapper();
    Compra c = m.map(input,Compra.class);

    c.setData(new Date());

    c.setCliente(clienteService.findById(input.getClienteId()));
    c.setProduto(produtoService.findById(input.getProdutoId()));

    return service.save(c);
  }

  public Boolean deleteCompra(Long id) {
    return service.deleteById(id);
  }
}
