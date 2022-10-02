package adt_reto0.dataAccess;

import adt_reto0.FileManager;
import adt_reto0.classes.Account;
import adt_reto0.classes.Movement;
import adt_reto0.interfaces.Movementable;
import java.util.Date;
import java.util.ArrayList;
import java.time.LocalDate;

public class FileDAMovement implements Movementable {

    private FileManager<Movement> fmMovement = new FileManager<>(Movement.class);
    private FileManager<Account> fmAccount = new FileManager<>(Account.class);
    
    public void registerMovement(Double destination, Double amount) {
        String description = amount > 0 ? "Desposit" : "Payment";
        Date timestamp = new Date();
        Integer id = fmMovement.getLastMatch(m -> !m.getId().equals(1)).getId();
        Double balance = fmMovement.getLastMatch(m -> m.getId().equals(id)).getBalance() + amount;
        
        Movement m = new Movement(id, amount, balance, description, timestamp, destination);
        fmMovement.addObject(m);
    }
                    
    public ArrayList<Movement> getAccountMovements(Double MovementId) {
        //TODO
        return null;
    }
    
}

