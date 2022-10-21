import java.util.Random;

class Quicksort extends Thread {
    private int arr[];
    private int low,high;
    public static int numThreads = Runtime.getRuntime().availableProcessors();
    public static int count = 0;

    public Quicksort(int[] arr, int low, int high){
        this.arr = arr;
        this.low = low;
        this.high = high;
    }

    public void run(){
        parallelQuicksort(arr,low,high);
    }

    public static void quicksort(int[] arr, int low, int high){
        if (high>low){
            int i = partition(arr,low,high);
            quicksort(arr,low,i-1);
            quicksort(arr,i+1,high);
        }
    }

    public static  void parallelQuicksort(int[] arr, int low, int high){
        if (high>low){
            int i = partition(arr,low,high);
            if (count < numThreads){
                count++;
                Quicksort quicksort  = new Quicksort(arr, low, i-1);
                quicksort.start();
                try{
                    quicksort.join();
                }
                catch (InterruptedException e){}
            }
            else{
                quicksort(arr,low,i-1);
            }
            if (count < numThreads){
                count++;
                Quicksort quicksort  = new Quicksort(arr, i+1, high);
                quicksort.start();
                try{
                    quicksort.join();
                }
                catch (InterruptedException e){}
            }
            else{
                quicksort(arr,i+1,high);
            }
        }
    }

    public static int partition(int[] arr, int start,int end)
    {

        int i = start, j = end;

        // Decide random pivot
        int pivote = new Random()
                .nextInt(j - i)
                + i;

        // Swap the pivote with end
        // element of array;
        int t = arr[j];
        arr[j] = arr[pivote];
        arr[pivote] = t;
        j--;

        // Start partitioning
        while (i <= j) {

            if (arr[i] <= arr[end]) {
                i++;
                continue;
            }

            if (arr[j] >= arr[end]) {
                j--;
                continue;
            }

            t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
            j--;
            i++;
        }

        // Swap pivote to its
        // correct position
        t = arr[j + 1];
        arr[j + 1] = arr[end];
        arr[end] = t;
        return j + 1;
    }

}