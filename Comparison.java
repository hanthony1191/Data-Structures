import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
/**
 *
 * @author AGH41
 */
public class Comparison {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initialize ArrayList
        ArrayList<String> AL = new ArrayList<String>();
        
        //Initialize LinkedList
        LinkedList<String> LL = new LinkedList<String>();
        
        //Add 1 million entries to ArrayList
        long start = System.nanoTime();
        for(int i=0; i<100000; i++){
            String input = Integer.toString(i);
            AL.add(input);
        }
        long end = System.nanoTime();
        long time = end - start;
        double AL_Add = (double)time / 1000000000;
        
        //Add 1 million entries to LinkedList
        long start1 = System.nanoTime();
        for(int i=0; i<100000; i++){
            String input = Integer.toString(i);
            LL.add(input);
        }
        long end1 = System.nanoTime();
        long time1 = end1 - start1;
        double LL_Add = (double)time1 / 1000000000;
        
        //Iterate through list and Get all entries
        long start2 = System.nanoTime();
        for(int i=0; i<AL.size(); i++){
            AL.get(i);
        }
        long end2 = System.nanoTime();
        long time2 = end2 - start2;
        double AL_Get = (double)time2 / 1000000000;
        
        //Iterate through list and Get all entries
        long start3 = System.nanoTime();
        for(int i=0; i<LL.size(); i++){
            LL.get(i);
        }
        long end3 = System.nanoTime();
        long time3 = end3 - start3;
        double LL_Get = (double)time3 / 1000000000;
        
        //Iterate through list and remove all entries
        long start4 = System.nanoTime();
        for(int i=(AL.size()-1); i>=0; i--){
            AL.remove(i);
        }
        long end4 = System.nanoTime();
        long time4 = end4 - start4;
        double AL_Remove = (double)time4 / 1000000000;
        
        //Iterate through list and remove all entries
        long start5 = System.nanoTime();
        ListIterator<String> itr = LL.listIterator();
        while(itr.hasNext()){
            itr.next();
            itr.remove();
        }
        long end5 = System.nanoTime();
        long time5 = end5 - start5;
        double LL_Remove = (double)time5 / 1000000000;
        
        //Display Times
        System.out.println("ArrayList add: " + AL_Add);
        System.out.println("LinkedList add: " + LL_Add);
        System.out.println("ArrayList get: " + AL_Get);
        System.out.println("LinkedList get: " + LL_Get);
        System.out.println("ArrayList remove: " + AL_Remove);
        System.out.println("LinkedList remove: " + LL_Remove);
    }
    
}
