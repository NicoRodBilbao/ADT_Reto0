/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.dataAccess;

import adt_reto0.classes.Account;
import adt_reto0.interfaces.Accountable;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 *
 * @author nikol
 */
public class DAAccount implements Accountable{
    private Connection con;
    private PreparedStatement stmt;
    
    final String createAccount = "INSERT INTO account (#, id, balance, beginBalance, beginBalanceTimestamp, creditLine, description, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    final String getAccData = "SELECT * FROM account where id = ?";
    
        
    public void createAccount(Integer customerId) {
            try {
                
                //con =
                //stmt = con.prepareStatement (createAccount);
            
            } catch (Exception e) {
            
            
            
            }
    
    }
    
    public void addClientToAccount(Integer customerId, Integer accountId) {
    
    }
    
    public Account getAccountData(Integer accountId) {
        Account data = null;
        
        
        return data;
    }
}
