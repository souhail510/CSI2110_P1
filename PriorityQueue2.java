import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;

//cette version est une file à priorité réalisée avec un tableau structuré en monceau (monceau Max)
public class PriorityQueue2<E extends Comparable<E>> implements PriorityQueueIF<E> {
    ArrayList<E> file;
    E [] MyList = null;
   


    public PriorityQueue2(){
    file=new ArrayList <E>();

    }
    public PriorityQueue2(ArrayList <E> arrayList){
      this.file=arrayList;

    }
  
    public boolean offer(E e) {
       if(isFull()){
         return false;
       }
       this.file.add(size()-1, e);
       upheap(MyList,size()-1);


       return true;
    }
    public static <E extends Comparable<E>> void  upheap(E [] heap,int indexElem) {
      E tempo;
      while (indexElem > 0) {
          int indexParent = (indexElem - 1) / 2;
          if (heap[indexElem].compareTo(heap[indexParent]) <= 0) {
              break;
          }
           tempo=heap[indexParent];
           heap[indexParent]=heap[indexElem];
           heap[indexElem]=tempo;
  
      }
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
      E firstElem=file.remove(0);
      E lastElem=file.get(size()-1);

      this.file.set(0,lastElem);
      file.remove(lastElem);
      toList(this.file);
      downheap(MyList , this.file.size() ,lastElem); 
        
       return firstElem;
    }
    public E [] toList(ArrayList<E> list){
     for(int j=0;j<list.size()-1;j++){
       MyList[j]=list.get(j);
     }
   
     return MyList;

    }

    public E  peek(){
      if(isEmpty()){
        return null;
      }
      return this.file.get(0);
         
    }

    public int size(){
        return this.file.size();
    }

    public boolean isEmpty(){
        return this.file.isEmpty();
    }
    
	public static <E extends Comparable<E>> void downheap(E heap[], int N, E k) {
		int j;
    int K =(Integer)k;
		E tempo = heap[K];
	
		// start at the last internal leaf
		while (K <= N/2) {
			j =K*2; // j is the first child
			// select the smallest of the two children
			if ( (j < N) && (heap[j+1].compareTo(heap[j]))<0 )
				j++;
		
			// compare with its parent
			if (tempo.compareTo(heap[j])<=0)
				break; // it is at its place
		
			// swap parent and child nodes
			heap[K] = heap[j];
			K = j;
		}
		heap[K] = tempo; 
	}


}