package com.ecommerce.repository;

import java.util.UUID;

import com.ecommerce.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, UUID> {
}
