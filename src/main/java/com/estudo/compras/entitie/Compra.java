package com.estudo.compras.entitie;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Compra {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Date data;
  private Integer quantidade;
  private String status;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "cliente_id", nullable = true)
  private Cliente cliente;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "produto_id", nullable = true)
  private Produto produto;
}
