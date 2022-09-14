/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.factory;

import adt_reto0.dataAccess.DAAccount;
import adt_reto0.interfaces.Accountable;

public class AccountADFactory {
    
    private static Accountable a = new DAAccount();
    
    public static Accountable getAccessAccount() {
        return a;
    }
    
}
