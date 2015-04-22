/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejer2;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author adrian
 */
public class Fail2ban implements Runnable {
    
    Thread thread;
    CopyOnWriteArrayList<Object> prohibited = new CopyOnWriteArrayList<Object>();
    CopyOnWriteArrayList<Object> exception = new CopyOnWriteArrayList<Object>();

    @Override
    public void run() {
        while(true){
            
        }
    }
    
    public void start(){
        thread= new Thread(this);
        thread.start();
        
    }
    
    public void addProhibitedAddress(Object address){
        if(!prohibited.contains(address)){
            deleteFromException(address);
            prohibited.add(address);
            System.out.println("addProhibitedAddress "+address);
        }
    }
    
    public void addExceptionAddress(Object address){
        if(prohibited.contains(address)){
            prohibited.remove(address);
        }
        if(!exception.contains(address)){
            exception.add(address);
            System.out.println("addExceptionAddress "+address);
        }
    }
    
    public void deleteFromException(Object address){
        exception.remove(address);
        System.out.println("delete "+address);
    }
    
}
