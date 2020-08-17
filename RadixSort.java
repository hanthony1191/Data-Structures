import java.util.*;

public class RadixSort {
    public static void main(String[] args) {
        int[] a = {85,3,19,43,20,55,42,21,91,85,73,29};
        
        //Print unsorted array.
        System.out.println("Unsorted Array: ");

        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        System.out.println();

        double start = System.nanoTime();
        //Sort the array.
        a=radixSort(a);
        double elapsed = (System.nanoTime()-start)/1000000000;
        
        //Print sorted array.
        System.out.println("Sorted Array: ");

        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Time Elapsed: \n" + elapsed);
    }   //End Main
    
    public static int[] radixSort(int[] a){
        //IMPLEMENT ME
        //References youtube.com, geeksforgeeks.com, java67.com
        int limit = 10;

        //Initialize 10 buckets (0-9) to store integers between passes
        ArrayList<Integer>[] buckets = new ArrayList[limit];

        for(int i=0; i<limit; i++){
            buckets[i] = new ArrayList<Integer>();
        }

        //Initialize variables for determining max value and place value
        boolean max = false;
        int temp = -1;
        int place = 1;

        //Main loop
        while(!max){
            max = true;

            //For every integer in array 'a', place in bucket relative to current place value
            for(Integer i : a){
                temp = i / place;
                buckets[temp % limit].add(i);
                if(max && temp > 0) {
                    max = false;
                }
            }

            //Empty buckets 0-9, FIFO, back into array 'a'
            int counter = 0;
            for(int index = 0; index < limit; index++){
                for(Integer i : buckets[index]){
                    a[counter++] = i;
                }
                buckets[index].clear();
            }

            //Move to next place value
            place *= limit;
        }

        return a;
    }   //End radixSort
}   //End Class