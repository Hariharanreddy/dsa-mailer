import java.util.ArrayList;
import java.util.Collections;

class BubbleSort {

    // Function to perform bubble sort on an ArrayList of integers
    public static void bubbleSort(ArrayList<Integer> arr, int n) {
        // Iterate through the array n-1 times
        for (int i = 1; i < n; i++) {
            // Flag to check if any swaps were made in this pass
            boolean swapped = false;

            // Iterate through the unsorted portion of the array
            for (int j = 0; j < n - i; j++) {
                // Compare adjacent elements and swap if necessary
                if (arr.get(j) > arr.get(j + 1)) {
                    Collections.swap(arr, j, j + 1); //Using Collections.swap for simplicity
                    swapped = true;
                }
            }

            // If no swaps were made, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(64);
        arr.add(34);
        arr.add(25);
        arr.add(12);
        arr.add(22);
        arr.add(11);
        arr.add(90);

        int n = arr.size();
        bubbleSort(arr, n);

        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
