import java.util.ArrayList;
import java.util.LinkedList;

// cette version est une file à priorité réalisée avec un simple tableau trié
// dans lequel l’élément maximum se trouve à la fin du tableau.

public class PriorityQueue1<E> implements PriorityQueueIF<E> {
    ArrayList<E> file;

    public PriorityQueue1(){
   file=new ArrayList <E>();

    }
    public PriorityQueue1(ArrayList <E> arrayList){
      this.file=arrayList;

    }
  
    public boolean offer(E e) {
       if(isFull()){
        return false;
       }
       this.file.add(e);
       return true;
    }
    public boolean isFull(){
        if(this.file.get(size()-1)==null){
            return false;
        }
        return true;
    }

    public  E  poll(){
        if(isEmpty()){
            return null;
        }
       E lastElem=this.file.get(size()-1);
       this.file.remove(size()-1);
       return lastElem;

    }

    public E  peek(){
        if(isEmpty()){
            return null;
        }
       return this.file.get(size()-1);
         
    }

    public int size(){
        return this.file.size();
    }

    public boolean isEmpty(){
        return this.file.isEmpty();
    }
  


}