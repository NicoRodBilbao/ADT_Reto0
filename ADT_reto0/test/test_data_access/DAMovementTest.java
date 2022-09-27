/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.dataAccess;

import adt_reto0.classes.Movement;
import java.sql.Date;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 2dam
 */
public class DAMovementTest {
    
    public DAMovementTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testRegisterMovement() {
        Movement movement = new Movement();
        movement.setId(9);
        movement.setTimestamp(Date.valueOf(LocalDate.now()));
        movement.setAmount(Double.MIN_NORMAL);
        movement.setBalance(Double.MIN_NORMAL);
        movement.setDescription("Desposit");
        Double account_id = null;
        String s = "2654785441";
        movement.setDestination(Double.valueOf(s));
        
        DAMovement mo = new DAMovement();
        mo.registerMovement(account_id, movement.getAmount());
        
        Assert.assertTrue(movement.equals(mo.getMovement(9))); 
        
    }
    
    public void testGetAccountMovements() {
        DAMovement mo = new DAMovement();
        Double account_id = null; 
        String s = "2654785441";
        account_id.valueOf(s);
        
        mo.getAccountMovements(account_id);
        
        
    }
    
    
    
}
