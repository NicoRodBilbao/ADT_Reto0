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
    
    void registerMovement(Double destination, Double amount) {
		try {
                    openConnection();
                    String descripcion;
                        if(amount>0){
                            descripcion="Desposit";
                        }else{
                            descripcion="Payment";
                        }
                        stmt = con.prepareStatement(getBalance);
                        stmt.setDouble(1, destination);
                        rs = stmt.executeQuery();
                        double balance = rs.getDouble(1);
                        stmt = con.prepareStatement(contarID);
                        stmt.setDouble(1, destination);
                        rs = stmt.executeQuery();
                        int id = rs.getInt(1) + 2;
                        
                    stmt = con.prepareStatement(registerMovement);
                    stmt.setInt(1, id);//insertar id automatico recogiendo ultimo id
                    stmt.setDouble(2, amount);//a insertar o restar
                    stmt.setDouble(3, balance + amount);//seleccionar balance de cuentas en una variable y sumale amount
                    stmt.setString(4, descripcion);//que le mande un String
                    stmt.setDate(5, Date.valueOf(LocalDate.now()));//recoger fecha y hora de ahora 
                    stmt.setDouble(6, destination);//destination es la cuenta
                    
                    stmt.executeUpdate();

                    closeConnection();
		
                } catch (Exception e) {
                    e.printStackTrace();
			
		}
    }
    
    Movement getMovement(int id){
       Movement mov = null;
        try {
            openConnection();
            stmt = con.prepareStatement(recogerMovimiento);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
                mov = new Movement(
                        rs.getInt(1),        //id
                        rs.getDouble(2),    //amount
                        rs.getDouble(3),   //balance
                        rs.getString(4),  //descripcion
                        rs.getDate(5), 
                        rs.getDouble(6)
                );
        } catch (Exception e) { // TODO gestionar excepción
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return mov; 
    }
    
    ArrayList getAccountMovements(Double accountId) {
        
         ArrayList arrMovement = new ArrayList<Movement>();
        
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
                        rs.getDate(5), 
                        accountId);  //Recoge Date (No esta correcto, me da error el Date)
                        
                arrMovement.add(movement);
            }
        } catch (Exception e) { // TODO gestionar excepción
            e.printStackTrace();
        }
         
        return arrMovement; // TODO return data
    }
    
private final String recogerMovimiento = "SELECT amount, balance, description, timestamp, account_id FROM movement where id=?";
private final String registerMovement = "Insert into movement values (?,?,?,?,?,?);";
private final String getBalance = "Select balance from account where id = ?;";
private final String contarID = "SELECT count(id) FROM movement";
private final String recogerMovimientos = "SELECT id, amount, balance, description, timestamp FROM movement where account_id=?";
}
