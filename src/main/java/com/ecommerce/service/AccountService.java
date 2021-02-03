package com.ecommerce.service;

import java.util.UUID;

import com.ecommerce.domain.Account;

public interface AccountService {

  Account getAccountById(UUID id);
  Account updateAccountById(Account account);
  void createAccount(Account account);
}
