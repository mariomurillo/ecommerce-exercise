package com.ecommerce.handler;

import java.util.UUID;

import com.ecommerce.handler.request.AccountRequest;
import com.ecommerce.handler.response.AccountResponse;
import com.ecommerce.domain.Account;
import com.ecommerce.domain.AccountType;
import com.ecommerce.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  private final AccountService service;

  public AccountController(final AccountService service) {
    this.service = service;
  }

  @GetMapping("/accounts")
  public ResponseEntity<AccountResponse> getAccount(@RequestParam(value = "id") String id) {
    return ResponseEntity.ok(getResponse(service.getAccountById(UUID.fromString(id))));
  }

  @PostMapping("/accounts")
  public ResponseEntity<Void> createAccount(@RequestBody AccountRequest request) {
    service.createAccount(getAccountFromRequest(request));
    return ResponseEntity.ok().build();
  }

  private AccountResponse getResponse(final Account account) {
    return AccountResponse
      .builder()
      .withId(account.getId())
      .withEmail(account.getEmail())
      .withType(account.getType().toString())
      .build();
  }

  private Account getAccountFromRequest(final AccountRequest request) {
    return Account.builder()
      .withEmail(request.getEmail())
      .withPassword(request.getPassword())
      .withType(AccountType.valueOf(request.getType()))
      .build();
  }
}
