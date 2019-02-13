package org.osama.demo.service;


import org.osama.demo.model.BankAccount;
import org.osama.demo.model.Wallet;
import org.osama.demo.repository.BankAccountRepository;
import org.osama.demo.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class WalletBankServiceImpl implements WalletBankService {
    @Autowired
    WalletRepository walletRepository;

    @Autowired
    BankAccountRepository bankAccountRepository;
    @Async
    @Override
    public CompletableFuture<List<Wallet>> getWallet() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Wallet> all = walletRepository.findAll();
        return CompletableFuture.completedFuture(all);
    }
    @Async
    @Override
    public CompletableFuture<List<BankAccount>> getBankAccount() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<BankAccount> all = bankAccountRepository.findAll();
        return CompletableFuture.completedFuture(all);
    }

    @Async
    @Override
    public CompletableFuture<String> withdrawAndAddToBankAccount(String userId,
                                                                 double amount)  {
        String response="";
        List<Wallet> walletRepositoryByUserId = walletRepository.findByUserId(userId);
        List<BankAccount> bankAccountRepositoryByUserId = bankAccountRepository.findByUserId(userId);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(walletRepositoryByUserId!=null){
            Wallet wallet = walletRepositoryByUserId.get(0);
            double balance = wallet.getBalance();
            balance-=amount;
            wallet.setBalance(balance);
            if(bankAccountRepositoryByUserId!=null){
                BankAccount bankAccount = bankAccountRepositoryByUserId.get(0);
                double balance1 = bankAccount.getBalance();
                balance1+=amount;
                bankAccount.setBalance(balance1);
                BankAccount save1 = bankAccountRepository.save(bankAccount);
                Wallet save = walletRepository.save(wallet);
                if(save!=null&&save1!=null){
                    response=save.getUserId()+" : Wallet is : "+save.getBalance()+save.getCurrency()
                           +save1.getBalance()+save1.getCurrency();
                }
            }
        }
        return CompletableFuture.completedFuture(response);
    }


}
