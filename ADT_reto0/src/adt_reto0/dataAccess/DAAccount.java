/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.dataAccess;

import adt_reto0.classes.Account;
import adt_reto0.interfaces.Accountable;
import adt_reto0.MasterConnection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author nikol
 */
public class DAAccount extends MasterConnection implements Accountable {
    
    
    final String createAccount = "INSERT INTO account (id, balance, beginBalance, beginBalanceTimestamp, creditLine, description, type) VALUES (?, ?, ?, ?, ?, ?, ?)";
    final String searchAccount = "SELECT * FROM account WHERE id = ?";
    final String getAccData = "SELECT * FROM account where id = ?";
    final String insertCustomersAccounts = "INSERT INTO customer_account(customers_id, accounts_id) values (?,?) ";
    final String searchCustomerId = "SELECT id FROM customer where id = ?";
    final String searchAccountId = "SELECT a.id FROM account where id = ?";
    
    Scanner sc = new Scanner(System.in);
    
    
        
    private  void createAccount() {
            
            try {
                  openConnection();
                  Integer newId;
                  System.out.println("Insert the new id");
                  newId = sc.nextInt();
                  //we search if there is an account with the same id
                  stmt = con.prepareStatement(searchAccount);
                  stmt.setInt(1,newId);
                  rs = stmt.executeQuery();
                  
                  
                  if(rs.next()) {
                      System.out.println("Error, an account with that id already exists");
                      try{
                          closeConnection();
                      }catch(Exception e) {
                          e.printStackTrace();
                      }finally {
                      
                      }
                  }else {
                      //Don't exist any account with that id, we can create a new one.
                      stmt = con.prepareStatement(createAccount);
                      stmt.setInt(1, newId);
                      System.out.println("What is the actual balance of the account?");
                      stmt.setDouble(2, sc.nextDouble());
                      System.out.println("What was the beginning balance of the account?");
                      stmt.setDouble(3, sc.nextDouble());
                      System.out.println("Insert the begin balance timestamp (dd/MM/yyyy)");
                      String dateLikeText = sc.next();
                      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                      Date date  = sdf.parse(dateLikeText);
                      stmt.setDate(4, (java.sql.Date) date);
                      System.out.println("Insert the credit line.");
                      stmt.setDouble(5, sc.nextDouble());
                      System.out.println("Insert a short description for the account");
                      stmt.setString(6, sc.next());
                      System.out.println("Insert the type of the account (0-Debit/1-Credit)");
                      stmt.setInt(7, sc.nextInt());
                      
                      stmt.executeUpdate();
                  }
                  
                  
                  
                  
            } catch (Exception e) {
            

            }finally {
            closeConnection();
            }
    
    }
    
    private void addClientToAccount(Integer customerId, Integer accountId) {
        try {
            openConnection();
            stmt = con.prepareStatement(searchCustomerId);
            stmt.setInt(1, customerId);
            rs = stmt.executeQuery();
            
            if(rs.next()) { 
                stmt = con.prepareStatement(searchAccountId);
                stmt.setInt(1, accountId);
                rs = stmt.executeQuery();
                if(rs.next()) {
                    stmt = con.prepareStatement(insertCustomersAccounts);
                    stmt.setInt(1, customerId);
                    stmt.setInt(2, accountId);
                    stmt.executeUpdate();
                } else {
                    System.out.println("The account doesn't exist.");
                }
            
            }else {
                System.out.println("The client doesn't exist.");
            
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
    }
    
    private Account getAccountData(Integer accountId) {
        Account data = null;
        
        
        return data;
    }

}
