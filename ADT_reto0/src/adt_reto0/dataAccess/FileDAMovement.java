package adt_reto0.dataAccess;

import adt_reto0.FileManager;
import adt_reto0.classes.Account;
import adt_reto0.classes.Movement;
import adt_reto0.interfaces.Movementable;
import java.util.Date;
import java.util.ArrayList;

public class FileDAMovement implements Movementable {

    private FileManager<Movement> fmMovement = new FileManager<>(Movement.class);
    private FileManager<Account> fmAccount = new FileManager<>(Account.class);
    
    public void registerMovement(Integer id, Double amount, Double balance, String description, Date timestamp, Double destination) {
        Movement m = new Movement(id, amount, balance, description, timestamp, destination);
        fmMovement.addObject(m);
    }
    
    public ArrayList<Movement> getAccountMovements(Double MovementId) {
        return null;
    }
    
}

