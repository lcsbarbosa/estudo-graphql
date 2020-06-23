package com.estudo.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.estudo.compras.entitie.Cliente;
import com.estudo.compras.entitie.ClienteInput;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

  @Autowired
  private ClientService clientService;

  public Cliente client(Long id) {
    return clientService.findById(id);
  }

  public List<Cliente> clients() {
    return clientService.findAll();
  }

  public Cliente saveClient(ClienteInput input) {
    Cliente client = new Cliente();
    client.setId(input.getId());
    client.setNome(input.getNome());
    client.setEmail(input.getEmail());

    return clientService.save(client);
  }

  public Boolean deleteClient(Long id){
    return clientService.deleteById(id);
  }
}
