package org.osama.demo.service;

import org.osama.demo.model.BankAccount;
import org.osama.demo.model.Wallet;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface WalletBankService {
    public CompletableFuture<List<Wallet>> getWallet();
    public CompletableFuture<List<BankAccount>> getBankAccount();
    public CompletableFuture<String> withdrawAndAddToBankAccount(String userId,
                                                                 double amount) throws InterruptedException;
}
