/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt_reto0.factory;

import adt_reto0.dataAccess.DACustomer;
import adt_reto0.interfaces.Customerable;

public abstract class CustomerDAFactory {
    
    private static Customerable c = new DACustomer();
    
    public static Customerable getAccessCustomer() {
        return c;
    }
    
}
