package com.ecommerce.domain;

public class Account {

  public void setId(String id) {
		this.id = id;
	}

private String id;

  private String email;

  private String password;

  private AccountType type;

  private Account(final String id, final String email, final String password, final AccountType type) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.type = type;
  }

  public String getId() {
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

  public static AccountBuilder builder() {
    return new AccountBuilder();
  }

  public static class AccountBuilder {

    private String id;

    private String email;
    
    private String password;
    
    private AccountType type;

    public AccountBuilder withId(final String id) {
      this.id = id;
      return this;
    }

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
      return new Account(this.id, this.email, this.password, this.type);
    }
  }
}
