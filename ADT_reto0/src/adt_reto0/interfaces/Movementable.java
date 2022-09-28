/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.interfaces;

import java.util.ArrayList;

public interface Movementable {
    public void registerMovement(Double destination, Double amount);
    
    public ArrayList getAccountMovements(Double accountId);
}
