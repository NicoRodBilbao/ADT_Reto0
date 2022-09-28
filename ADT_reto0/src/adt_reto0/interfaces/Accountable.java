/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.interfaces;

import adt_reto0.classes.Account;

/**
 *
 * @author nikol
 */
public interface Accountable {
        public void createAccount(Account personalData);
        
        public boolean addClientToAccount(Integer customerId, Integer accountId);
        
        public Account getAccountData(Integer accountId);
                
}
