package com.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import java.util.UUID;
import org.hibernate.annotations.Type;

@Entity                    
public class Account {
  @Id
  @Type(type="org.hibernate.type.UUIDCharType")
  private UUID id = UUID.randomUUID();
  
  private String email;
  private String password;

  @Enumerated(EnumType.STRING)
  private AccountType type;

  public UUID getId() {
    return this.id;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPassword() {
    return this.password;
  }

  public AccountType getType() {
    return this.type;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public void setType(final AccountType type) {
    this.type = type;
  }

  public static AccountBuilder builder() {
    return new AccountBuilder();
  }

  public static class AccountBuilder {

    private String email;

    private String password;

    private AccountType type;

    public AccountBuilder withEmail(final String email) {
      this.email = email;
      return this;
    }

    public AccountBuilder withPassword(final String password) {
      this.password = password;
      return this;
    }

    public AccountBuilder withType(final AccountType type) {
      this.type = type;
      return this;
    }

    public Account build() {
      Account account = new Account();
      account.setEmail(this.email);
      account.setPassword(this.password);
      account.setType(this.type);

      return account;
    }
  }
}
