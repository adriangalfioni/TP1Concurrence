package concurrencia;

/**
 * ConcurrentStack
 * <p/>
 * Nonblocking stack using Treiber's algorithm
 *
 * @author Brian Goetz and Tim Peierls
 */
import java.util.concurrent.atomic.*;

public class ConcurrentQueue {

    // a reference to a node -- initially set to null
    AtomicReference<Node> head = new AtomicReference<Node>();//salida
    AtomicReference<Node> tail = new AtomicReference<Node>();//entrada

    public void enqueue(Object item) {
        Node newTail = new Node(item);
        Node oldTail=tail.get();
        Node oldHead=head.get();
        
        if (oldHead!=null && oldTail!=null) {
            do{
            oldTail.next = newTail;
            }while(!tail.compareAndSet(oldTail,newTail));
        } else {
            do{
          
            }while(!(tail.compareAndSet(oldTail, newTail) && head.compareAndSet(oldHead, newTail)));
        }
        
    }
    
   
    public void toString2(){
        Node aux= head.get();
        while(aux!=null){
            System.out.println(aux.item);
            aux= aux.next;
        }
    }



    public Object dequeue() {
        Node oldHead;
        Node newHead;
        boolean aux=false;
        do{
            aux =false;
            oldHead = head.get();
            if (oldHead == null) {
                return null;
            } 
            newHead = oldHead.next;
            if(newHead==null){
                aux=tail.compareAndSet(oldHead,newHead);
            }
            }while(!head.compareAndSet(oldHead, newHead) && !aux);
        return oldHead.item;
        
    }

    private static class Node {

        public final Object item;
        public Node next;

        public Node(Object item) {
            this.item = item;
        }
    }
}
