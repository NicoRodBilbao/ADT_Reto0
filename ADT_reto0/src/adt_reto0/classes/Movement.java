/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.classes;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author nikol
 */
public class Movement implements Serializable {
    private Integer id;
    private LocalDate timestamp;
    private Double amount;
    private Double balance;
    private String description;

    public Movement() {
    }

    public Movement(Integer id, Double amount, Double balance, String description) {
        this.id = id;
        timestamp = LocalDate.now();
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movement{" + "id=" + id + ", timestamp=" + timestamp + ", amount=" + amount + ", balance=" + balance + ", description=" + description + '}';
    }
    
}
