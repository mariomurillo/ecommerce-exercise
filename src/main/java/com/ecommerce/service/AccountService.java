package com.ecommerce.service;

import java.util.UUID;

import com.ecommerce.domain.Account;
import com.ecommerce.exceptions.AccountException;

public interface AccountService {

  Account getAccountById(UUID id);
  void updateAccountById(Account account);
  void createAccount(Account account) throws AccountException;
  void deleteAccountById(UUID id);
}
