/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_data_access;

import adt_reto0.classes.Movement;
import adt_reto0.dataAccess.DAMovement;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 2dam
 */
public class DAMovementTest {
    
    String s = "12345678";
    Movement movement = new Movement();
    Movement movement2 = new Movement();
    
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
        
        movement.setId(8);
        movement.setTimestamp(Date.valueOf(LocalDate.now()));
        movement.setAmount(Double.MIN_NORMAL);
        movement.setBalance(Double.MIN_NORMAL);
        movement.setDescription("Desposit");
        movement.setDestination(Double.valueOf(s));
        
        movement2.setId(8);
        movement2.setTimestamp(Date.valueOf(LocalDate.now()));
        movement2.setAmount(Double.MIN_NORMAL);
        movement2.setBalance(Double.MIN_NORMAL);
        movement2.setDescription("Desposit");
        movement2.setDestination(Double.valueOf(s));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * compare a movement insterted
     */
    @Test
    public void testRegisterMovement() {
        
        DAMovement mo = new DAMovement();
        mo.registerMovement(Double.valueOf(s), movement.getAmount());
        Assert.assertTrue(movement.equals(mo.getMovement(8))); 
        
    }
    
    /**
     * get all the movements form one account and compare the last movement with one insterted
     */
    @Test
    public void testGetAccountMovements() {
        DAMovement mo = new DAMovement();
        
        ArrayList arr = new ArrayList(mo.getAccountMovements(Double.valueOf(s)));
        
        int i = 0;
        mo.registerMovement(Double.valueOf(s), movement.getAmount());
        for(i=arr.size(); i<0; i--){
            Assert.assertTrue(movement.equals(mo.getMovement(8)));
            break;
        }
    }
}
