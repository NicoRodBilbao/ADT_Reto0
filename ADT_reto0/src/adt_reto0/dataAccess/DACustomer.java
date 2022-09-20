package adt_reto0.dataAccess;

import adt_reto0.classes.Account;
import adt_reto0.classes.Customer;
import adt_reto0.interfaces.Customerable;
import adt_reto0.MasterConnection;

public class DACustomer extends MasterConnection implements Customerable {
    
    void createCustomer(Integer customerId, String firstName, String lastName, String middleInitial, String street, String city, String state, String email, Integer zip, Integer phone) {
        try {
            openConnection();
            stmt = con.prepareStatement(insertar);
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
                stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    
    Customer getCustomerData(Integer customerId) {
        Customer cus = null;
        try {
            openConnection();
            stmt = con.prepareStatement(buscar);
            stmt.setInt(1, customerId);
            rs = stmt.executeQuery();
                cus = new Customer(
                        rs.getInt(1),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(2),
                        rs.getString(8),
                        rs.getString(3),
                        rs.getInt(10),
                        rs.getInt(7)
                );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return cus;
    }
    
    Account[] getCustomerAccounts(Integer customerId) {
        
        return null; // TODO return data
    }
    private final String insertar = 
        "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String buscar = 
        "SELECT * FROM customer WHERE id  = ?";
}
