package adt_reto0.dataAccess;

import adt_reto0.classes.Account;
import adt_reto0.classes.Customer;
import adt_reto0.interfaces.Customerable;
import adt_reto0.MasterConnection;
import java.util.ArrayList;

public class DACustomer extends MasterConnection implements Customerable {
    
    public static void createCustomer(Integer customerId, String firstName, String lastName, String middleInitial, String street, String city, String state, String email, Integer zip, Integer phone) {
        try {
            openConnection();
            stmt = con.prepareStatement(insertar); // Prepare SQL sentence to insert the data
            // Load data into the statement
            stmt.setInt(1, customerId);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, middleInitial);
            stmt.setString(5, street);
            stmt.setString(6, city);
            stmt.setString(7, state);
            stmt.setString(8, email);
            stmt.setInt(9, zip);
            stmt.setInt(10, phone);
            
                stmt.executeUpdate(); // Inserts the data into the database
        } catch (Exception e) { // TODO gestionar excepción
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    
    public static Customer getCustomerData(Integer customerId) {
        Customer cus = null;
        try {
            openConnection();
            stmt = con.prepareStatement(buscar);
            stmt.setInt(1, customerId);
            rs = stmt.executeQuery();
                cus = new Customer(
                        rs.getInt(1),          // id 
                        rs.getString(4),    // firstName
                        rs.getString(5),    // lastName
                        rs.getString(6),    // middleInital
                        rs.getString(9),    // street
                        rs.getString(2),    // city
                        rs.getString(8),    // state
                        rs.getString(3),    // email
                        rs.getInt(10),        // zip
                        rs.getInt(7)           // phone
                );
        } catch (Exception e) { // TODO gestionar excepción
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return cus; 
    }
    
    public static ArrayList getCustomerAccounts(Integer customerId) {
        ArrayList arrayAcc = new ArrayList<Account>();
        
        try {
            stmt = con.prepareStatement(getCuentas);
            stmt.setInt(1, customerId);
            rs = stmt.executeQuery();
            for (int i = 1; i <= arrayAcc.size(); i++) {
                rs.next();
                Account account = new Account(
                        rs.getInt(1),           // id
                        rs.getString(6),     // description
                        rs.getDouble(2),   // balance
                        rs.getDouble(5),   // creditLine
                        rs.getDouble(3),   // beginBalance
                        rs.getDate(4),       // beginBalanceTime
                        rs.getInt(7));          // type 
                arrayAcc.add(account);
            }
        } catch (Exception e) { // TODO gestionar excepción
            e.printStackTrace();
        }
        return arrayAcc; 
    }
    
    // SQL statement declaration
    private static final String insertar = 
        "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String buscar = 
        "SELECT * FROM customer WHERE id  = ?";
    
    private static final String  contarCuentas =
        "SELECT COUNT * FROM customer_account WHERE customers_id = ?";
    
    private static final String getCuentas =
        "SELECT accounts_id, account.balance, account.beginBalance, account.beginBalanceTimestamp, account.creditLine, account.description, account.type\n" +
        "FROM customer_account\n" +
        "RIGHT JOIN account\n" +
        "ON customer_account.accounts_id = account.id\n" +
        "WHERE customer_account.customers_id = ?;";
}
