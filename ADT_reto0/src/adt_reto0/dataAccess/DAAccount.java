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


public class DAAccount extends MasterConnection implements Accountable {
    
    
    final String createAccount = "INSERT INTO account (id, balance, beginBalance, beginBalanceTimestamp, creditLine, description, type) VALUES (?, ?, ?, ?, ?, ?, ?)";
    final String searchAccount = "SELECT * FROM account WHERE id = ?";
    final String getAccData = "SELECT * FROM account where id = ?";
    final String insertCustomersAccounts = "INSERT INTO customer_account(customers_id, accounts_id) values (?,?) ";
    final String searchCustomerId = "SELECT id FROM customer where id = ?";
    final String searchAccountId = "SELECT a.id FROM account where id = ?";
    
    Scanner sc = new Scanner(System.in);
 
        
    public void createAccount(Account personalData) {
            
            try {
                  openConnection();
                  System.out.println("Insert the new id");
                  personalData.setId(sc.nextInt());
                  //we search if there is an account with the same id
                  stmt = con.prepareStatement(searchAccount);
                  stmt.setInt(1,personalData.getId());
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
                      stmt.setInt(1, personalData.getId());
                      System.out.println("What is the actual balance of the account?");
                      personalData.setBalance(sc.nextDouble());
                      stmt.setDouble(2, personalData.getBalance());
                      System.out.println("What was the beginning balance of the account?");
                      personalData.setBeginBalance( sc.nextDouble());
                      stmt.setDouble(3,personalData.getBeginBalance());
                      System.out.println("Insert the begin balance timestamp (dd/MM/yyyy)");
                      String dateLikeText = sc.next();
                      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                      Date date  = sdf.parse(dateLikeText);
                      personalData.setBeginBalanceTimestamp(date);
                      stmt.setDate(4, (java.sql.Date) personalData.getBeginBalanceTimestamp());
                      System.out.println("Insert the credit line.");
                      personalData.setCreditLine(sc.nextDouble());
                      stmt.setDouble(5, personalData.getCreditLine());
                      System.out.println("Insert a short description for the account");
                      personalData.setDescription(sc.next());
                      stmt.setString(6, personalData.getDescription());
                      System.out.println("Insert the type of the account (0-Standard/1-Credit)");
                      personalData.setType(sc.nextInt());
                      stmt.setInt(7, personalData.getType());
                      
                      stmt.executeUpdate();
                  }
                  
                  
                  
                  
            } catch (Exception e) {
            

            }finally {
            closeConnection();
            }
    
    }
    

    public boolean addClientToAccount(Integer customerId, Integer accountId) {
        boolean added = false;
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
                    added = true;
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
        return added;
    }
    
    public Account getAccountData(Integer accountId) {
        Account personalAcc = null;
        try {
            openConnection();
            stmt = con.prepareStatement(searchAccount);
            System.out.println("What is the id of the account you want to search?");
            stmt.setInt(1, sc.nextInt());
            rs = stmt.executeQuery();
            
            //We search the wanted account and if it exists we fill the data
            if (rs.next()) { 
                personalAcc.setId(rs.getInt(1));
                personalAcc.setBalance(rs.getDouble(2));
                personalAcc.setBeginBalance(rs.getDouble(3));
                personalAcc.setBeginBalanceTimestamp(rs.getDate(4));
                personalAcc.setCreditLine(rs.getDouble(5));
                personalAcc.setDescription(rs.getString(6));
                personalAcc.setType(rs.getInt(7));
            }
            
        } catch (Exception e) {
        }finally {
            closeConnection();
        }
        
        
        
        return personalAcc;
    }
}
