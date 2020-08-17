import java.util.concurrent.TimeUnit;

public class Prime{
    public int setLimit(int n){
        int limit = 10000*n;
        return limit; 
    } 

    public int countPrimes(int x){
        int primes = 1;
        boolean isPrime = false;
        for(int i=3; i<x; i++){
            for(int j=2; j<i; j++){
                if(i%j==0){
                    isPrime = false;
                    break;
                }
                else {
                    isPrime = true;
                }
            }
            if(isPrime == true){
                primes += 1;
            }    
        }
        return primes;
    }

    public static void main(String[] args){
        Prime count = new Prime();
        for(int i=1; i<11; i++){
            long start = System.nanoTime();
            int input = count.setLimit(i);
            int output = count.countPrimes(input);
            long end = System.nanoTime();
            long time = end - start;
            double seconds = (double)time / 1000000000;
            System.out.println("The program is on Step " + i + " - Primes found: " + output);
            System.out.println("This step took " + seconds + " seconds to complete");
        }
    }
}