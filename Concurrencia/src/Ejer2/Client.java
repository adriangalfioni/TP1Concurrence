/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejer2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adrian
 */
public class Client implements Runnable{
    
    Fail2ban f2b;
    String operation;
    Thread thread;
    
    public Client(Fail2ban f2b, String op){
        this.f2b=f2b;
        operation = op;
    }

    @Override
    public void run() {
        int i=0;
        if(operation.equalsIgnoreCase("addProhibitedAddress")){
            while(true){
                f2b.addProhibitedAddress(++i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(operation.equalsIgnoreCase("addExceptionAddress")){
            while(true){
                f2b.addExceptionAddress(++i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(operation.equalsIgnoreCase("deleteFromException")){
            while(true){
                f2b.deleteFromException(++i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void start(){
        thread= new Thread(this);
        thread.start();
        
    }
    
}
