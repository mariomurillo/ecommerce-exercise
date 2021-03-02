package com.ecommerce.service;

import java.util.UUID;

import com.ecommerce.domain.Account;
import com.ecommerce.domain.AccountType;
import com.ecommerce.exceptions.AccountException;
import com.ecommerce.handler.request.AccountRequest;
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
  public void  createAccount(final Account account) throws AccountException {
	  try {
     repository.save(getAccount(account));
  }
	  catch (Exception e) {
		  throw new AccountException("Can´t create account at this time. Please try again later");	
	}
	  
  }
  
  @Override
  public void updateAccountById(Account account ) {
	  com.ecommerce.model.Account accountFound = repository.findById(UUID.fromString(account.getId())).get();
	  accountFound.setEmail(account.getEmail());
	  accountFound.setPassword(account.getPassword());
	  accountFound.setType(com.ecommerce.model.AccountType.valueOf(account.getType().name()));
	  repository.save(accountFound);
  }

  @Override
  public void deleteAccountById(UUID id) {
	  repository.deleteById(id);
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
