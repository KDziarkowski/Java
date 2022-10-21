import java.util.Date;
import java.util.Random;
public class Test{
        public static void main(String[] args) {

        int[] arr = new int[1000000];
        int[] arr2 = new int[1000000];
            //generate random array of size 1000000
        for(int i=0 ; i<1000000; i++){
            int random = (int)Math.floor(Math.random()*1000000);
            arr[i] = random;
            arr2[i] = random;
        }

        Date d0 = new Date();
        Quicksort.quicksort(arr,0,arr.length -1);
        Date d1 = new Date();
        System.out.println("Single array sorted in "+(d1.getTime()-d0.getTime())+" ms");

        Quicksort.parallelQuicksort(arr2,0,arr.length -1);
        Date d2 = new Date();
        System.out.println("Threaded array sorted in "+(d2.getTime()-d1.getTime())+" ms");
    }
}