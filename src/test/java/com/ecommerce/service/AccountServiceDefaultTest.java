package com.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

import com.ecommerce.domain.Account;
import com.ecommerce.domain.AccountType;
import com.ecommerce.exceptions.ConnectionException;
import com.ecommerce.repository.AccountRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AccountServiceDefaultTest {

  private AccountService service;
  private AccountRepository repository;

  @BeforeEach
  public void setUp() {
    repository = mock(AccountRepository.class);
    service = new AccountServiceDefault(repository);
  }

  /**
   * This method tests the account creation successfully
   * */
  @Test
  public void createAccountSuccessfulTest() {
    // The method `when` of Mockito together with the method `thenReturn` return
    // something that we put into the parameter in `thenReturn` after to
    // invoke the method `when`
    // The `any` method return an any objetc
    Mockito.when(repository.save(any())).thenReturn(any());

    Account account = Account.builder()
      .withEmail("test@email.com")
      .withType(AccountType.ADMIN)
      .build();

    try {
      service.createAccount(account);
    } catch (ConnectionException ce) {
      // If the `createAccount` method return an Exception the test fail
      fail();
    }

    // The `verify` method verify that a method is called the quantity that
    // is in the parameter in the `times` method
    Mockito.verify(repository, times(1)).save(any());
  }

  /**
   * This method tests the account creation with an Exception during the process
   * */
  @Test
  public void createAccountWithExceptionTest() {
    // We use the method `thenThrow` of Mockito to simulate the throw of an
    // Exception when we call the method save
    Mockito.when(repository.save(any())).thenThrow(new RuntimeException());

    Account account = Account.builder()
      .withEmail("test@email.com")
      .withType(AccountType.ADMIN)
      .build();

    try {
      service.createAccount(account);
    } catch (ConnectionException ce) {
      // We hope the `createAccount` throw an Exception and that exception that
      // the same message that we put into the `assertEquals` method.
      assertEquals(
          "Can´t create account at this time. Please try again later",
          ce.getMessage());
    }

    Mockito.verify(repository, times(1)).save(any());
  }
}
