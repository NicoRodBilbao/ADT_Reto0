package adt_reto0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public abstract class MasterConnection {
    protected static Connection con;
    protected static PreparedStatement stmt;
    protected static ResultSet rs;
    // access to the configuration file.
    protected static ResourceBundle configFile = 
        ResourceBundle.getBundle("adt_reto0.config");;
    protected static String 
        url = configFile.getString("Conn"),
        user = configFile.getString("DBUser"),
        pass = configFile.getString("DBPass");

    

    protected static void openConnection() {
        con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.err.println("Mal");
        }
    }

    protected static void closeConnection() {
        try {
            if (stmt != null) 
            stmt.close();
        
            if (con != null)
                con.close();
        } catch (SQLException sqle) {}
    }

    /**In case of an error, returns. Otherwise,
     * returns the number of rows of the full table 
     * in the database.
     * @throws SQLException in case something goes wrong.
     */
    protected int cantidadTotal(String database) {
        int pTotal = -1;
        database = "SELECT COUNT(*) FROM " + database;
        
        try {
            openConnection();
            stmt = con.prepareStatement(database);
            rs = stmt.executeQuery();
                rs.next();
            pTotal = rs.getInt(1);
        } catch (SQLException sqle) {
            System.err.println("Mal cerrar");
        } finally {
            closeConnection();
        }
        
        return pTotal;
    }
}