/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILabs.Misc;

import GSILabs.BModel.*;
import GSILabs.BSystem.BussinessSystem;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Alex
 */
public class SSTest05 {        
    
    private static BussinessSystem bSystem;
    
    public static void main(String[] args) throws IOException{
        
        final File file = new File("P05Ej02.ods");
        bSystem = new BussinessSystem();        
        int ticketsOk = bSystem.importTickets(file);
        System.out.println("El numero de tickets introducidos: "+ ticketsOk);
        
    }
        
}
