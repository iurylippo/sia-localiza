package com.sia.localiza.api.modules.auth.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.sia.localiza.api.common.abstractions.DateAudit;
import com.sia.localiza.api.modules.auth.enums.TokenType;
import com.sia.localiza.api.modules.users.entities.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tokens")
public class Token extends DateAudit {
  @Id
  @GeneratedValue()
  @UuidGenerator
  private UUID id;

  @Column(name = "token", unique = true)
  public String token;

  @Enumerated(EnumType.STRING)
  @Column(name = "type")
  public TokenType tokenType = TokenType.BEARER;

  @Column(name = "revoked")
  public boolean revoked;

  @Column(name = "expired")
  public boolean expired;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  public User user;
}
