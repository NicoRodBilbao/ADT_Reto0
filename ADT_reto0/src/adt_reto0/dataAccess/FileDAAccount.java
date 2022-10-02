package adt_reto0.dataAccess;

import adt_reto0.FileManager;
import adt_reto0.classes.Account;
import adt_reto0.classes.Customer;
import adt_reto0.interfaces.Accountable;
import java.util.ArrayList;

public class FileDAAccount implements Accountable {

    private FileManager<Account> fmAccount = new FileManager<>(Account.class);
    private FileManager<Customer> fmCustomer = new FileManager<>(Customer.class);
    
    @Override
    public void createAccount(Account a) {
        fmAccount.addObject(a);
    }

    @Override
    public Account getAccountData(Integer id) {
        return fmAccount.getLastMatch(c -> c.getId().equals(id));
    }

	@Override
	public boolean addClientToAccount(Integer customerId, Integer accountId) {
		Account acc = fmAccount.getLastMatch(a -> a.getId().equals(accountId));
		acc.addCustomer(fmCustomer.getLastMatch(c -> c.getId().equals(customerId)));
		fmAccount.addObject(acc);
		return false;
	}
   
}

