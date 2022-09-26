/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.dataAccess;


import org.junit.After;
import org.junit.AfterClass;
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
        DAMovement mo = new DAMovement();
        mo.registerMovement(1234455, Double.MIN_NORMAL);
        
        
    }
    
    public void testGetAccountMovements() {
        DAMovement mo = new DAMovement();
        mo.getAccountMovements(234566);
        
    }
    
    
    
}
