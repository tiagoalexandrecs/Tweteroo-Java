package com.api.tweteroo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity  // Indica ao banco que isso é uma entidade a ser mapeada
@Table(name = "tweteroo_users")  // Permite escolher o nome da tabela
public class UserModel {

  @Id // Identifica que é o id, a chave primária da tabela
  @GeneratedValue(strategy = GenerationType.AUTO) // Estratégia gerar IDs
  private Long id;

  @Column(length = 150, nullable = false) 
  private String avatar;

 @Column(nullable = false)
  private String username;
}
