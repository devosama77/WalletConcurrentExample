package org.osama.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    @Column(name = "user_id")
    String userId;
    @Column(name = "balance")
    private double balance;
    @Column(name = "currency")
    private String currency;
    @Column(name = "last_updated")
    private Date lastUpdated;
    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    public BankAccount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
