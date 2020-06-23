package com.estudo.compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.estudo.compras.entitie.Cliente;
import com.estudo.compras.repository.ClienteRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

  @Autowired
  private ClienteRepository clienteRepository;

  public Cliente cliente(Long id){
    return clienteRepository.findById(id).orElse(null);
  }

  public List<Cliente> clientes(){
    return clienteRepository.findAll();
  }

  public Cliente saveClient(Long id, String nome, String email) {
    Cliente client = new Cliente();
    client.setId(id);
    client.setNome(nome);
    client.setEmail(email);

    return clientService.save(client);
  }

  public Boolean deleteClient(Long id){
    return clientService.deleteById(id);
  }
}
