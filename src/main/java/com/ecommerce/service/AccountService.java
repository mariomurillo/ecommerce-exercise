package com.ecommerce.service;

import java.util.UUID;

import com.ecommerce.domain.Account;
import com.ecommerce.exceptions.ConnectionException;

public interface AccountService {

  Account getAccountById(UUID id);
  void updateAccountById(Account account);
  void createAccount(Account account) throws ConnectionException;
  void deleteAccountById(UUID id);
}
