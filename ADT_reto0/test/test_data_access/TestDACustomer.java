package test_data_access;

import adt_reto0.MasterConnection;

import static org.junit.Assert.*;
import adt_reto0.dataAccess.DAAccount;
import adt_reto0.dataAccess.DACustomer;
import adt_reto0.classes.Customer;
import adt_reto0.classes.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDACustomer extends MasterConnection {
    
    private Customer testCustomer;
    

    @Test
    public void testCreateClient() {
        System.err.println("aaaaaaaaaaaaaaaa");
         try {
             System.out.println("1");
            openConnection();
             System.out.println("2");
            // Data Insert tests
            stmt = con.prepareStatement(insertarCus1);
            stmt.executeUpdate();
            stmt = con.prepareStatement(insertarCus2);
            stmt.executeUpdate();
            stmt = con.prepareStatement(insertarAcc1);
            stmt.executeUpdate();
            stmt = con.prepareStatement(insertarAcc2);
            stmt.executeUpdate();
            stmt = con.prepareStatement(insertarCusAcc1);
            stmt.executeUpdate();
            stmt = con.prepareStatement(insertarCusAcc2);
            stmt.executeUpdate();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
         assertEquals("a","a");
    }
    
    @Test
    public void testGetCustomerData() {
        //TODO
    }
    
    @Test
    public void testGetCustomerAccounts() {
        //TODO
    }
    
    private final String insertarCus1 = 
        "INSERT INTO customer VALUES (1, Bilbao, email, Nicolas, Rodriguez, B, 123456789, California, Sq, 48002)";
    
    private final String insertarCus2 = 
        "INSERT INTO customer VALUES (2, Bilbao, email, Markel, Fernandez, S, 123456789, California, Sq, 48002)";  
    
    
    private final String insertarAcc1 = 
        "INSERT INTO account VALUES (1, 1, 1, 2019-01-14 19:19:04.000, 1, a, 1)";  
    
    private final String insertarAcc2 = 
        "INSERT INTO account VALUES (2, 1, 1, 2019-01-14 19:19:04.000, 1, a, 1)"; 
    
    
    private final String insertarCusAcc1 = 
        "INSERT INTO customer_account VALUES (1, 1)";  
    
    private final String insertarCusAcc2 = 
        "INSERT INTO customer_account VALUES (1, 2)"; 
    
}
