package com.estudo.compras.graphql.service;

import com.estudo.compras.entitie.Compra;
import com.estudo.compras.repository.CompraRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

  @Autowired
  private CompraRepository repository;

  public Compra findById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public List<Compra> findAll() {
    return repository.findAll();
  }

  @Transactional
  public Compra save(Compra c) {
    return repository.save(c);
  }

  @Transactional
  public boolean deleteById(Long id) {
    if(repository.findById(id).isPresent()) {
      repository.deleteById(id);
      return true;
    }
    return false;
  }
}
