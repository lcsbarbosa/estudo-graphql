package com.estudo.compras.graphql.service;

import com.estudo.compras.entitie.Cliente;
import com.estudo.compras.repository.ClientRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

  @Autowired
  private ClientRepository repository;

  public Cliente findById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public List<Cliente> findAll() {
    return repository.findAll();
  }

  @Transactional
  public Cliente save(Cliente client) {
    return repository.save(client);
  }

  @Transactional
  public Boolean deleteById(Long id) {
    if (repository.findById(id).isPresent()) {
      repository.deleteById(id);
      return true;
    }
    return false;
  }
}
