/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrencia;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nico
 */
public class Producer implements Runnable{

    Thread thread;
    Buffer buffer;
    String thName;
    
    @Override
    public void run() {
        int i = 0;
        Random r = new Random(1);
        while(true){
            try {
                Thread.sleep(r.nextInt(1000)*3);
                buffer.enqueue(thName+i);
                i++;
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void start(){
        thread= new Thread(this);
        thread.start();
        
    }

    public Producer(String name, Buffer buffer) {
        this.buffer = buffer;
        thName=name;
    }
}
