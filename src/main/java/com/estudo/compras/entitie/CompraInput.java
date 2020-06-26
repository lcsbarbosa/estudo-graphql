package com.estudo.compras.entitie;

import lombok.Data;

@Data
public class CompraInput {

  private Long id;
  private Integer quantidade;
  private String status;

  private Long clienteId;

  private Long produtoId;
}
