package com.ecommerce.handler.response;

public class AccountResponse {

  private String id;

  private String email;

  private String type;

  private AccountResponse(final String id, final String email, final String type) {
    this.id = id;
    this.email = email;
    this.type = type;
  }

  public String getId() {
    return this.id;
  }

  public String getEmail() {
    return this.email;
  }

  public String getType() {
    return this.type;
  }

  public static AccountResponseBuilder builder() {
    return new AccountResponseBuilder();
  }

  public static class AccountResponseBuilder {

    private String id;

    private String email;

    private String type;

    public AccountResponseBuilder withId(final String id) {
      this.id = id;
      return this;
    }

    public AccountResponseBuilder withEmail(final String email) {
      this.email = email;
      return this;
    }

    public AccountResponseBuilder withType(final String type) {
      this.type = type;
      return this;
    }

    public AccountResponse build() {
      return new AccountResponse(this.id, this.email, this.type);
    }
  }
}
