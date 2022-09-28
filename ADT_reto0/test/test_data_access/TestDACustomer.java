package test_data_access;

import adt_reto0.MasterConnection;

import static org.junit.Assert.*;
import adt_reto0.dataAccess.DAAccount;
import adt_reto0.dataAccess.DACustomer;
import adt_reto0.classes.Customer;
import adt_reto0.classes.Account;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDACustomer extends MasterConnection {
    
    private Customer testCustomer;
    private DACustomer Dac;
    private DAAccount Daa;
    
    @Before
    public void setUp() {
        Dac.createCustomer(1, "Nicolas", "Rodriguez", "B", "Sq", "Bilbao", "California", "a@b.com", 48002, 666666666);
        Dac.createCustomer(2, "Markel", "Fernandez", "S", "Sq", "Bilbao", "California", "b@b.com", 48002, 666666665);
        Daa.createAccount(new Account(1,"a",1.0,1.0,1.0,new Date(2022, 9, 26),1));
        Daa.createAccount(new Account(2,"a",1.0,1.0,1.0,new Date(2022, 9, 26),1));
        Daa.addClientToAccount(1, 1);
        Daa.addClientToAccount(1, 2);
    }    
    
    @Test
    public void testCreateClient() {
         assertEquals((Integer)1, DACustomer.getCustomerData(1).getId());
    }
    
    @Test
    public void testGetCustomerData() {
        assertEquals(0, DACustomer.getCustomerData(1).compareTo(testCustomer));
    }
    
    @Test
    public void testGetCustomerAccounts() {
        ArrayList custList = DACustomer.getCustomerAccounts(1);
        assertEquals(2, custList.size());
    }
    
    @After
    public void tearDown() {
        try {
            openConnection();
            // DELETE all created customers and accounts relations
            stmt = con.prepareStatement(borrarCusAcc);
            stmt.setInt(1, 1);
            stmt.setInt(2, 1);
            stmt.executeUpdate();
            stmt = con.prepareStatement(borrarCusAcc);
            stmt.setInt(1, 1); 
            stmt.setInt(2, 2);
            stmt.executeUpdate();
            // DELETE all created accounts during the tests
            stmt = con.prepareStatement(borrarCus);
            stmt.setInt(1, 1); 
            stmt.executeUpdate();
            stmt = con.prepareStatement(borrarCus);
            stmt.setInt(1, 2); 
            stmt.executeUpdate();
            // DELETE all created customers created during the tests
            stmt = con.prepareStatement(borrarCus);
            stmt.setInt(1, 1); 
            stmt.executeUpdate();
            stmt = con.prepareStatement(borrarCus);
            stmt.setInt(1, 2); 
            stmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
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

    private final String buscarCus =
        "SELECT id FROM customer WHERE id = ?";
    
    
    private final String borrarCus =
        "DELETE FROM customer WHERE id = ?";
    
    private final String borrarAcc =
        "DELETE FROM account WHERE id = ?";
    
    private final String borrarCusAcc =
        "DELETE FROM customer_account WHERE customers_id = ? AND accounts_id = ?";
    
}
