package com.estudo.compras.graphql.service;

import com.estudo.compras.entitie.Produto;
import com.estudo.compras.entitie.ProdutoInput;
import com.estudo.compras.repository.ProductRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public Produto findById(Long id){
    return repository.findById(id).orElse(null);
  }

  public List<Produto> findAll() {
    return repository.findAll();
  }

  @Transactional
  public Produto save(Produto produto) {
    return repository.save(produto);
  }

  @Transactional
  public Boolean deleteById(Long id) {
    if(repository.findById(id).isPresent()){
      repository.deleteById(id);
      return true;
    }
    return false;
  }
}
