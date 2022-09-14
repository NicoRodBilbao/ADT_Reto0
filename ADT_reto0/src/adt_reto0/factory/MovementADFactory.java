/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.factory;

import adt_reto0.classes.Movement;
import adt_reto0.dataAccess.DAMovement;
import adt_reto0.interfaces.Movementable;

public class MovementADFactory {
    
    private static Movementable m = new DAMovement();
    
    public static Movementable getAccessMovement() {
        return m;
    }
}
