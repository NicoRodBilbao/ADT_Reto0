/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.interfaces;

import adt_reto0.classes.Customer;
import java.util.ArrayList;

/**
 *
 * @author nikol
 */
public interface Customerable {
    public void createCustomer(Integer customerId, String firstName, String lastName, 
            String middleInitial, String street, String city, String state, 
            String email, Integer zip, Integer phone);
    
    public Customer getCustomerData(Integer customerId);

     public ArrayList getCustomerAccounts(Integer customerId);
}
