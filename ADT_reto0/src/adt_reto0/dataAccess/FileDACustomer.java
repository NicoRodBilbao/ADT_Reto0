package adt_reto0.dataAccess;

import adt_reto0.FileManager;
import adt_reto0.classes.Account;
import adt_reto0.classes.Customer;
import adt_reto0.interfaces.Customerable;
import java.util.ArrayList;

public class FileDACustomer implements Customerable {

    private FileManager<Customer> fmCustomer = new FileManager<>(Customer.class);
    private FileManager<Account> fmAccount = new FileManager<>(Account.class);
    
    public void createCustomer(Integer id, String firstName, String lastName, String middleInitial, String street, String city, String state, String email, Integer zip, Integer phone) {
        Customer cus = 
            new Customer(id
                , firstName
                , lastName
                , middleInitial
                , street
                , city
                , state
                , email
                , zip
                , phone);
        fmCustomer.addObject(cus);
    }
    
    public Customer getCustomerData(Integer id) {
        return fmCustomer.getLastMatch(c -> c.getId().equals(id));
    }
    
    public ArrayList<Account> getCustomerAccounts(Integer id) {
        // TODO relate customer to account in order to search
        // for the accounts related to a customer
        return null;
    }
    
}

