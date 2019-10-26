import java.util.Random;
import java.util.Scanner;

public class QuickSort {
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Random r = new Random();
    
    System.out.println("Enter Number of elements: ");
    int n = input.nextInt();
    int[] num = new int[n];
   
    int Low = 1;
    int High = 100;

    for (int i = 0; i < n; i++) {
        num[i] = r.nextInt(High - Low) + Low;       //generate random numbers 
    }
    long start = System.currentTimeMillis();
    //System.out.println("\nGiven Array " + num.length + " Elements:");
    //printSortedArray(num);
    sort(num, 0, n - 1);
    System.out.println("\nSorted Array for " + num.length + " Elements:");
    printSortedArray(num);
    long end = System.currentTimeMillis();
    long timeElapsed = end - start;
    System.out.println("\nQuickSort - Time Taken : " + timeElapsed + " milliseconds\n");
    
    
    input.close();
    
}

public static int partition(int arr[], int low, int high) {

    // pivot 
    int pivot = arr[high]; 
     // index of smaller element
    int i = (low - 1);                               //0 - 1 = -1 
    for (int j = low; j < high; j++) {
        // If current element is smaller than pivot
        if (arr[j] <= pivot) {          
            i++;         // increment index of smaller element 
            // swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
        // swap arr[i+1] and pivot to finish sort
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
}

/* low = starting index,  high = Ending index */
public static void sort(int arr[], int low, int high) {
    if (low < high) {
    // pi is partitioning index,
    int pi = partition(arr, low, high);
    // Recursively sort elements before
    // partition and after partition
    sort(arr, low, pi - 1);
    sort(arr, pi + 1, high);
    }
}

public static void printSortedArray(int[] num) {
    for (int i = 0; i < num.length; i++) {
    System.out.print(num[i] + " ");
    }
}
}