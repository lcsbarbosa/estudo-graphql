package com.estudo.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.estudo.compras.entitie.Cliente;
import com.estudo.compras.entitie.ClienteInput;
import com.estudo.compras.graphql.service.ClienteService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

  @Autowired
  private ClienteService service;

  public Cliente cliente(Long id) {
    return service.findById(id);
  }

  public List<Cliente> clientes() {
    return service.findAll();
  }

  public Cliente saveCliente(ClienteInput input) {
    ModelMapper mapper = new ModelMapper();
    Cliente client = mapper.map(input, Cliente.class);

    return service.save(client);
  }

  public Boolean deleteCliente(Long id){
    return service.deleteById(id);
  }
}
