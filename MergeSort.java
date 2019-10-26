
import java.util.Random;
import java.util.Scanner;
public class MergeSort {

public static void main(String[] args) {
    long start, finish, timeElapsed;

    Random r = new Random();
    int Low = 1;
    int High = 100;

    Scanner input = new Scanner(System.in);
    System.out.println("Enter Number of elements: ");
    int n = input.nextInt();        //take user input
    int[] num = new int[n];         //number of elements into array

    for (int i = 0; i < n; i++) {
         num[i] = r.nextInt(High - Low) + Low;      //put each random num in array
    }
    start = System.currentTimeMillis();
    // System.out.print("Given Array is: \n");
    // printSortedArray(num);
    sort(num, 0, n-1);
    finish = System.currentTimeMillis();
    timeElapsed = finish - start;
    // System.out.println("Given Array is \n");
    System.out.println("\nSorted Array for "+ num.length +" Elements:");
    printSortedArray(num);
    System.out.println("\n\nMerge Sort: Time Taken: " + timeElapsed + " milliseconds\n");
    input.close();
}

// Merges two subarrays of arr[]. 
// First subarray is arr[l..m] 
// Second subarray is arr[m+1..r]
public static void merge(int arr[], int l, int m, int r) {
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    /* Create temp arrays */
    int L[] = new int[n1];
    int R[] = new int[n2];

    /* Copy data to temp arrays */
    for (int i = 0; i < n1; ++i)
        L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
        R[j] = arr[m + 1 + j];
        
/* Merge the temp arrays back into arr[l..r]*/
    int i = 0;      // Initial indexes of first
    int j = 0;      // Initial indexes of second
    int k = l;      // Initial index of merged subarry array
    while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
                k++;
    }
    /* Copy remaining elements of L[] if any */
    while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
    /* Copy remaining elements of R[] if any */
    while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

public static void sort(int arr[], int l, int r) {
    if (l < r) {
        // Find the middle point
        int m = (l + r) / 2;
        // Sort first and second halves
        sort(arr, l, m);
        sort(arr, m + 1, r);
        merge(arr, l, m, r);        //Merge
    }
}
public static void printSortedArray(int[] num) {
    for (int i = 0; i < num.length; i++) {
        System.out.print(num[i] + " ");
    }
}
}