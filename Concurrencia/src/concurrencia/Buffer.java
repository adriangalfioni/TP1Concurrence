/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrencia;

import java.util.Random;

/**
 *
 * @author nico
 */
public class Buffer implements Runnable{

    private Thread thread;
    private ConcurrentQueue queue1;
    private ConcurrentQueue queue2;
    
    @Override
    public void run() {
        while(true){
            
        }
    }
    
    public void enqueue(Object item){
        randomQueue().enqueue(item);
        //this.notifyAll();
    }
    
    public Object dequeue(){
        return RandomDequeue();
    }
    
    public void start(){
        thread = new Thread(this);
        thread.start();
        
    }

    
    public ConcurrentQueue randomQueue(){
        Random r = new Random(200);
        if(r.nextInt()%2==0){
            return queue1;
        }else{
            return queue2;
        }
    }
    
    public Object RandomDequeue(){
        Random r = new Random(200);
        Object item;
        if(r.nextInt()%2==0){
            item = queue1.dequeue();
            if (item == null){
                item = queue2.dequeue();
                return item;
            }
        }else{
            item = queue2.dequeue();
            if (item == null){
                item = queue1.dequeue();
                return item;
            }
        }
        return item;
    }

    public Buffer() {
        queue1= new ConcurrentQueue();
        queue2= new ConcurrentQueue();
    }
    
    
}
