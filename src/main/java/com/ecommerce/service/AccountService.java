package com.ecommerce.service;

import java.util.UUID;

import com.ecommerce.domain.Account;

public interface AccountService {

  Account getAccountById(UUID id);

  void createAccount(Account account);
  void deleteAccountById(UUID id);
}
