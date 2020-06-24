package com.estudo.compras.graphql.service;

import com.estudo.compras.entitie.Produto;
import com.estudo.compras.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public Produto findById(Long id){
    return repository.findById(id).orElse(null);
  }
}
