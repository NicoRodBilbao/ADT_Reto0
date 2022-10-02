package adt_reto0.interfaces;

import java.util.ArrayList;
import adt_reto0.classes.Movement;

public interface Movementable {
    public void registerMovement(Double destination, Double amount);
    
    public ArrayList<Movement> getAccountMovements(Double accountId);
}
