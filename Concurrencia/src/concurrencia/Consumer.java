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
public class Consumer implements Runnable{

    Thread thread;
    Buffer buffer;
    String thName;
    
    @Override
    public void run() {
        int i=0;
        while(true){
            Object item = buffer.dequeue();
            if (item == null){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println(thName+" Dequeue: "+item);
            }
        }
    }
    
    public void start(){
        thread= new Thread(this);
        thread.start();
        
    }

    public Consumer(String name, Buffer buffer) {
        this.buffer = buffer;
        thName = name;
    }
}
