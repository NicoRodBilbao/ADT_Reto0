/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.classes;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

public class Account implements Serializable{
        private Integer id;
        private ArrayList<Customer> customers; 
        private ArrayList<Movement> movements; 
        private String description;
        private Double balance;
        private Double creditLine;
        private Double beginBalance;
        //no sabemos si es localdate o no.
        private Date beginBalanceTimestamp;
        private Integer type;

    public Account() {
    }
    
    public Account(Integer id) {
        this.id = id;
    }

    public Account(Integer id, String description, Double balance, Double creditLine, Double beginBalance, Date beginBalanceTimestamp, Integer type) {
        this.id = id;
        this.customers = new ArrayList<Customer>();
        this.description = description;
        this.balance = balance;
        this.creditLine = creditLine;
        this.beginBalance = beginBalance;
        this.beginBalanceTimestamp = beginBalanceTimestamp;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }
    
    public void addCustomer(Customer c) {
        this.customers.add(c);
    }

    public void addMovement(Movement m) {
        this.movements.add(m);
    }
    
    public ArrayList<Movement> getMovements() {
        return this.movements;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(Double creditLine) {
        this.creditLine = creditLine;
    }

    public Double getBeginBalance() {
        return beginBalance;
    }

    public void setBeginBalance(Double beginBalance) {
        this.beginBalance = beginBalance;
    }

    public Date getBeginBalanceTimestamp() {
        return beginBalanceTimestamp;
    }

    public void setBeginBalanceTimestamp(Date beginBalanceTimestamp) {
        this.beginBalanceTimestamp = beginBalanceTimestamp;
    }
    
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", description=" + description + ", balance=" + balance + ", creditLine=" + creditLine + ", beginBalance=" + beginBalance + ", beginBalanceTimestamp=" + beginBalanceTimestamp + ", type= " + type + '}';
    }
        
}
