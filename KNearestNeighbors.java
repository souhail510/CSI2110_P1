
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class KNearestNeighbors {
      int  k;
      static Float [] MyList;
      static int [] MyList2;
      static ArrayList<LabelledPoint> neighbors;
      static int counter=0;
      static int count=0;
      static PriorityQueue<Double> heap;  // Declare the PriorityQueue here

      public KNearestNeighbors(){

      }
   
	// finds the k nearest neighbors of query point in list of points
    public static ArrayList<LabelledPoint> findKNearestNeighbors(LabelledPoint query, List<LabelledPoint> points, int k,String argument) {	
          PriorityQueueIF<Double> heap=null;
        
       switch(argument){
        case "1":       
              heap = new PriorityQueue1<Double>(); 

        case "2":
              heap = new PriorityQueue2<Double>();  
               
        case "3" :
              heap= new PriorityQueue3<Double>();
                   
     } 



               for(int i=0;i<points.size()-1;i++){

                // doesn't add point if it is bigger than last point in queue
              
                if(heap.size()>k){
                  if(points.get(i).distanceTo(query)>=heap.peek()){
                    continue;
                }
            }
                heap.offer(points.get(i).distanceTo(query));           
                if(heap.size()>k){
                   heap.poll();
                }
                 } 
        
                 MyList = new Float[k+1];
                 MyList2 = new int[k+1];

                 // remove from heap and add to both lists
                 for(int i=0;i<k;i++){
                    Double db=heap.poll();

                    MyList[i]=db.floatValue();
                    MyList2[i]=db.intValue();

                 }
            
                 ArrayList<LabelledPoint> neighbors=new ArrayList<LabelledPoint>();

                 neighbors.add(new LabelledPoint(MyList,counter));
                 counter++;
                

                 toString(MyList2,neighbors.get(0));
 
        return neighbors;
                }

    public void setK(int k){
        this.k=k;
    }
   
    public static void main(String[] args) {
      
        
        // liste des query points
        PointSet queryPts = new PointSet(PointSet.read_ANN_SIFT(args[3]));
        ArrayList<LabelledPoint> query =queryPts.getPointsList();

		// liste des vecteurs
        PointSet pointSet = new PointSet(PointSet.read_ANN_SIFT(args[2]));
        ArrayList<LabelledPoint> lesVecteurs =pointSet.getPointsList();
     
        
        int k=Integer.parseInt(args[1]);
        

       ArrayList<LabelledPoint> nearestNeighbors=null;

       
        long startTime = System.currentTimeMillis(); // start timer
        // chaque query point a sa propre liste de vecteurs

       for (int i=0;i<query.size()-1;i++){        
         nearestNeighbors = findKNearestNeighbors(query.get(i), lesVecteurs, k,args[0]);
           System.out.println("K Nearest Neighbors:");
       }

       long endTime = System.currentTimeMillis(); // end timer
        System.out.println("Execution time: " + (endTime - startTime) + " milliseconds");

         
        }


     public static String toString(int [] list,LabelledPoint neighbor){

          // print liste des k les plus proches
        StringBuilder sb = new StringBuilder("(");

      sb.append(neighbor.getLabel()+" : ");

        for (int i=0; i<list.length-1; i++) {
           
             if(i==list.length-2){
                 sb.append(list[i]);
                 break;
            }
            sb.append(list[i]).append(", ");
           
        }
        sb.append(")");
        System.out.println(sb);
        return sb.toString();
    }
    }
      
      
    

