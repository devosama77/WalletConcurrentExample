package org.osama.demo.repository;

import org.osama.demo.model.BankAccount;
import org.osama.demo.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface WalletRepository extends JpaRepository<Wallet,Integer> {
  public List<Wallet> findByUserId(String userId);
}
