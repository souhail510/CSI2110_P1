import java.util.ArrayList;
import java.util.PriorityQueue;

// cette version utilise la classe standard java.PriorityQueue
public class PriorityQueue3<E> implements PriorityQueueIF<E> {
    PriorityQueue<E> file;

    public PriorityQueue3(){
   file=new PriorityQueue<E>();

    }
    public PriorityQueue3(ArrayList <E> arrayList){
     for(int i=0;i<arrayList.size()-1;i++){
        file.offer(arrayList.get(i));
     }

    }
  
    public boolean offer(E e) {
       return this.file.offer(e);
    }

    public  E  poll(){
       return this.file.poll();
    }

    public E  peek(){
        return this.file.peek();
         
    }

    public int size(){
        return this.file.size();
    }

    public boolean isEmpty(){
        return this.file.isEmpty();
    }
  


}