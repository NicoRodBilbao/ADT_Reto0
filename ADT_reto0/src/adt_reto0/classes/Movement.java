/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.classes;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author nikol
 */
public class Movement implements Serializable {
    private Integer id;
    private Date timestamp;
    private Double amount;
    private Double balance;
    private String description;
    private Double destination;

    public Movement() {
    }

    public Movement(Integer id, Double amount, Double balance, String description, Date timestamp, Double destination) {
        this.id = id;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        this.timestamp = timestamp;
        this.destination = destination;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
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
    
    public Double getDestination() {
        return destination;
    }
    
    public void setDestination(Double destination) {
        this.destination = destination;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movement other = (Movement) obj;
        return true;
    }   
}
