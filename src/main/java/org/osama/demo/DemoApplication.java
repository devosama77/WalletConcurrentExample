package org.osama.demo;

import org.osama.demo.model.BankAccount;
import org.osama.demo.model.Wallet;
import org.osama.demo.repository.BankAccountRepository;
import org.osama.demo.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Date;
import java.util.concurrent.Executor;

@EnableAsync
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Autowired
    WalletRepository walletRepository;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public void run(String... args) throws Exception {
        Wallet wallet=new Wallet();
        wallet.setBalance(50);
        wallet.setUserId("osama");
        wallet.setLastUpdated(new Date());
        wallet.setCurrency("$");
        walletRepository.save(wallet);

        BankAccount bankAccount=new BankAccount();
        bankAccount.setBalance(0);
        bankAccount.setCurrency("$");
        bankAccount.setLastUpdated(new Date());
        bankAccount.setUserId("osama");
        bankAccountRepository.save(bankAccount);
    }

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(1);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("Wallet Account-");
        executor.initialize();
        return executor;
    }
}

