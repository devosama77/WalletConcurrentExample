package org.osama.demo.repository;

import org.osama.demo.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository
        extends JpaRepository<BankAccount,Integer> {
    public List<BankAccount> findByUserId(String userId);
}
