/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrencia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nico
 */
public class Concurrencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Buffer buffer= new Buffer();
        Thread b= new Thread(buffer);
        b.start();
        
        //Producer producer= new Producer(buffer);
        //Consumer consumer = new Consumer(buffer);
        
        Thread p0= new Thread(new Producer("p1",buffer));
        Thread p1= new Thread(new Producer("p2",buffer));
        Thread c0= new Thread(new Consumer("c0",buffer));
        Thread c1= new Thread(new Consumer("c1",buffer));
        
        p0.start();
        p1.start();
        c0.start();
        c1.start();
        
        //buffer.getQueue1().toString2();
    }
    
}
