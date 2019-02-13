package org.osama.demo.controllers;

import org.osama.demo.model.BankAccount;
import org.osama.demo.model.Wallet;
import org.osama.demo.service.WalletBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class WalletController {
    @Autowired
    WalletBankService walletBankService;

//    get only wallet for user osama
    @GetMapping( value = "/wallets",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Wallet> getWallet() throws ExecutionException, InterruptedException {
        CompletableFuture<List<Wallet>> wallet = walletBankService.getWallet();
        CompletableFuture.allOf(wallet).join();
        List<Wallet> wallets = wallet.get();
        return wallets;
    }

    //    get bank account for user osama
    @GetMapping( value = "/bank",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BankAccount> getBankAccount() throws ExecutionException, InterruptedException {
        CompletableFuture<List<BankAccount>> bankAccount = walletBankService.getBankAccount();
        CompletableFuture.allOf(bankAccount).join();
        List<BankAccount> bankAccounts = bankAccount.get();
        return bankAccounts;
    }

    //    withdraw from wallet and and add to bank account ..
    @PutMapping( value = "/wallets/amount={amount}&&user={userId}",produces = MediaType.TEXT_PLAIN_VALUE)
    public String WithdrawWallet(@PathVariable("amount") String amount,
                                @PathVariable("userId") String userId)
            throws ExecutionException, InterruptedException {

        double amountDouble= Double.parseDouble(amount);


        CompletableFuture<String> stringCompletableFuture = walletBankService.withdrawAndAddToBankAccount(userId, amountDouble);

        // Wait until they are all done
        CompletableFuture.allOf(stringCompletableFuture).join();
        String response = stringCompletableFuture.get();
        return response;
    }
}
