/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.interfaces;

import java.util.ArrayList;
import java.util.Date;
import adt_reto0.classes.Movement;

public interface Movementable {
    public void registerMovement(Integer id, Double amount, Double balance, String description, Date timestamp, Double destination);
    
    public ArrayList<Movement> getAccountMovements(Double accountId);
}
