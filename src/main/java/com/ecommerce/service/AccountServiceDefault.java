package com.ecommerce.service;

import java.util.UUID;

import com.ecommerce.domain.Account;
import com.ecommerce.domain.AccountType;
import com.ecommerce.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service("userService")
public class AccountServiceDefault implements AccountService {

  private final AccountRepository repository;

  public AccountServiceDefault(final AccountRepository repository) {
    this.repository = repository;
  }

  @Override
  public Account getAccountById(UUID id) {
    return getAccount(repository.findById(id).get());
  }

  @Override
  public void createAccount(final Account account) {
    repository.save(getAccount(account));
  }

  private Account getAccount(com.ecommerce.model.Account account) {
    return Account
      .builder()
      .withId(account.getId().toString())
      .withEmail(account.getEmail())
      .withPassword(account.getPassword())
      .withType(AccountType.valueOf(account.getType().name()))
      .build();
  }

  private com.ecommerce.model.Account getAccount(Account account) {
    return com.ecommerce.model.Account
      .builder()
      .withEmail(account.getEmail())
      .withPassword(account.getPassword())
      .withType(com.ecommerce.model.AccountType.valueOf(account.getType().name()))
      .build();
  }
}
