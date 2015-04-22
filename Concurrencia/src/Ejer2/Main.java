/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejer2;

import concurrencia.Producer;

/**
 *
 * @author adrian
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        Fail2ban f2b = new Fail2ban();
    
        Thread p0= new Thread(new Client(f2b, "addProhibitedAddress"));
        Thread p1= new Thread(new Client(f2b, "addProhibitedAddress"));

        Thread p2= new Thread(new Client(f2b, "addExceptionAddress"));
        Thread p3= new Thread(new Client(f2b, "addExceptionAddress"));
        Thread p6= new Thread(new Client(f2b, "addExceptionAddress"));
        Thread p7= new Thread(new Client(f2b, "addExceptionAddress"));
        Thread p8= new Thread(new Client(f2b, "addExceptionAddress"));
        Thread p9= new Thread(new Client(f2b, "addExceptionAddress"));
        Thread p10= new Thread(new Client(f2b, "addExceptionAddress"));

        Thread p4= new Thread(new Client(f2b, "deleteFromException"));
        Thread p5= new Thread(new Client(f2b, "deleteFromException"));
        
        f2b.start();
        
        p0.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
        p8.start();
        p9.start();
        p.start();
        
    }
    
    
    
    
}
