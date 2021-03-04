package com.ecommerce.handler;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.domain.Account;
import com.ecommerce.domain.AccountType;
import com.ecommerce.exceptions.AccountException;
import com.ecommerce.handler.request.AccountRequest;
import com.ecommerce.handler.response.AccountResponse;
import com.ecommerce.service.AccountService;

@RestController
public class AccountController {

  private final AccountService service;

  public AccountController(final AccountService service) {
    this.service = service;
  }

  @GetMapping("/accounts")
  public ResponseEntity<AccountResponse> getAccount(
      @RequestParam(value = "id") final String id) {
    return ResponseEntity
        .ok(getResponse(service.getAccountById(UUID.fromString(id))));
  }

  @PostMapping("/accounts")
  public ResponseEntity<String> createAccount(
      @RequestBody final AccountRequest request) {
    try {
      service.createAccount(getAccountFromRequest(request));
      return ResponseEntity.ok("Account created successfully");

    } catch (AccountException ce) {
      return ResponseEntity.ok(ce.getMessage());
    }

  }

  @DeleteMapping("/accounts/{id}")
  public void deleteAccountById(@PathVariable(value = "id") final UUID id) {

    service.deleteAccountById(id);

  }

  @PutMapping("/accounts/{id}")
  public ResponseEntity<AccountResponse> updateAccount(
      @RequestBody final AccountRequest request,
      @PathVariable(value = "id") final UUID id) {
    Account account = getAccountFromRequest(request);
    account.setId(id.toString());
    service.updateAccountById(account);
    return ResponseEntity.ok().build();

  }


  private AccountResponse getResponse(final Account account) {
    return AccountResponse.builder().withId(account.getId())
        .withEmail(account.getEmail()).withType(account.getType().toString())
        .build();
  }

  private Account getAccountFromRequest(final AccountRequest request) {
    return Account.builder().withEmail(request.getEmail())
        .withPassword(request.getPassword())
        .withType(AccountType.valueOf(request.getType())).build();
  }
}
