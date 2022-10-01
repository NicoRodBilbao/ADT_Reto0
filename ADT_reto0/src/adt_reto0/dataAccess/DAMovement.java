/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.dataAccess;

import adt_reto0.classes.Movement; 
import adt_reto0.interfaces.Movementable;
import adt_reto0.MasterConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;


public class DAMovement extends MasterConnection implements Movementable{
    private PreparedStatement stmt;
    
    /**
     * Generate a movement and insert in database
     * @param destination
     * @param amount
     */
    @Override
    public void registerMovement(Double destination, Double amount) {
		try {
                    openConnection();
                    String descripcion;
                        if(amount>0){
                            descripcion="Desposit";
                        }else{
                            descripcion="Payment";
                        }
                        //get balance of accounts
                        stmt = con.prepareStatement(getBalance);
                        stmt.setDouble(1, destination);
                        rs = stmt.executeQuery();
                        double balance = rs.getDouble(1);
                        //get id for the movement
                        stmt = con.prepareStatement(countID);
                        stmt.setDouble(1, destination);
                        rs = stmt.executeQuery();
                        int id = rs.getInt(1) + 2;
                        
                    stmt = con.prepareStatement(registerMovement);
                    stmt.setInt(1, id);//instert last id
                    stmt.setDouble(2, amount);//amount to insert
                    stmt.setDouble(3, balance + amount);//get total of balance and amount
                    stmt.setString(4, descripcion);//Deposit or Payment
                    stmt.setDate(5, Date.valueOf(LocalDate.now()));//take the date of today
                    stmt.setDouble(6, destination);//the account afected
                    
                    stmt.executeUpdate();
                    
                    closeConnection();
		
                    stmt = con.prepareStatement(setBalance);
                    stmt.setDouble(1, balance + amount);
                    stmt.setDouble(2, destination);
                    rs = stmt.executeQuery();
                    
                } catch (Exception e) {
                    e.printStackTrace();
		}
    }
    
    /**
     * Get a movement
     * @param id
     */
    public Movement getMovement(double id){
       Movement mov = null;
        try {
            openConnection();
            stmt = con.prepareStatement(getMovement);
            stmt.setDouble(1, id);
            rs = stmt.executeQuery();
                mov = new Movement(
                        rs.getInt(1),     //id
                        rs.getDouble(2),  //amount
                        rs.getDouble(3),  //balance
                        rs.getString(4),  //descripcion
                        rs.getDate(5),    //Date of movement
                        rs.getDouble(6)   //account_id
                );
        } catch (Exception e) { // TODO gestionar excepción
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return mov; 
    }
    
    
    /**
     * Get all the movement from one account_id
     * @param accountId
     * @return arrMovement
     */
    @Override
    public ArrayList getAccountMovements(Double accountId) {
        
        ArrayList arrMovement = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(recogerMovimientos);
            stmt.setDouble(1, accountId);
            rs = stmt.executeQuery();
            for (int i = 1; i <= arrMovement.size(); i++) {
                rs.next();
                Movement movement = new Movement(
                        rs.getInt(1),        //id
                        rs.getDouble(2),    //amount
                        rs.getDouble(3),   //balance
                        rs.getString(4),  //descripcion
                        rs.getDate(5),    //Date of movement
                        accountId);       //id of account
                        
                arrMovement.add(movement);
            }
        } catch (Exception e) { // TODO gestionar excepción
            e.printStackTrace();
        }
         
        return arrMovement; // TODO return data
    }
    
private final String getMovement = "SELECT amount, balance, description, timestamp, account_id FROM movement where id=?";
private final String registerMovement = "Insert into movement values (?,?,?,?,?,?);";
private final String getBalance = "Select balance from account where id = ?;";
private final String setBalance = "Update account set balance = ? where id = ?;";
private final String countID = "SELECT count(id) FROM movement";
private final String recogerMovimientos = "SELECT id, amount, balance, description, timestamp FROM movement where account_id=?";

}
