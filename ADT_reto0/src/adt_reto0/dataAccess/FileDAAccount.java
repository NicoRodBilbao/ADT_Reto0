package adt_reto0.dataAccess;

import adt_reto0.FileManager;
import adt_reto0.classes.Account;
import adt_reto0.classes.Customer;
import adt_reto0.interfaces.Accountable;
import java.util.ArrayList;

public class FileDAAccount implements Accountable {

    private FileManager<Account> fmAccount = new FileManager<>(Account.class);
    private FileManager<Customer> fmCustomer = new FileManager<>(Customer.class);
    
    public void createAccount(Account a) {
        fmAccount.addObject(a);
    }
    
    public Account getAccountData(Integer id) {
        return fmAccount.getLastMatch(c -> c.getId().equals(id));
    }
    
    public ArrayList<Account> getAccountCustomers(Integer id) {
        // TODO relate Account to account in order to search
        // for the accounts related to a Account
        return null;
    }
    
}

