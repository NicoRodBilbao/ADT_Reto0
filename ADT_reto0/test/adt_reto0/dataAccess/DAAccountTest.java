/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.dataAccess;

import adt_reto0.classes.Account;
import adt_reto0.interfaces.Accountable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 2dam
 */
public class DAAccountTest {
    Accountable acc = new DAAccount();
            
    @Test 
    public void testCreateAccount(){
        Account testAcc = new Account();
        LocalDate ld = LocalDate.now();
        Date date = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
        testAcc.setId(1223);
        testAcc.setBalance(126.00);
        testAcc.setBeginBalance(94.93);
        testAcc.setBeginBalanceTimestamp(date);
        testAcc.setCreditLine(56.32);
        testAcc.setDescription("This is a test account");
        testAcc.setType(1);
        
        try {
            assertEquals(acc.getAccountData(testAcc.getId()), testAcc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
               
    }
    
    @Test 
    public void testaddClientToAccount(){
    }
    
    @Test 
    public void testgetAccountData(){
    }
    
}
