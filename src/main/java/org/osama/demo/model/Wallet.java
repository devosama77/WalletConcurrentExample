package org.osama.demo.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "wallet")
public class Wallet {
   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
   @Column(name = "id")
    int id;
    @Column(name = "user_id")
    String userId;
    @Column(name = "balance")
    private  double balance;
    private String currency;
    private Date lastUpdated;
    private String lastUpdatedBy;

    public Wallet(String userId, double balance, String currency,
                  Date lastUpdated, String lastUpdatedBy) {
        this.userId = userId;
        this.balance = balance;
        this.currency = currency;
        this.lastUpdated = lastUpdated;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Wallet() {
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
