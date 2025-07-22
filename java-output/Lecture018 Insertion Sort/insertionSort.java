import java.util.ArrayList;
import java.util.List;

public class InsertionSort {

    // Function to implement insertion sort
    public static void insertionSort(int n, List<Integer> arr) {

        // Iterate through the array starting from the second element
        for (int i = 1; i < n; i++) {
            // Store the current element in a temporary variable
            int temp = arr.get(i);
            int j = i - 1;

            // Iterate backward from the current element until the beginning of the array
            for (; j >= 0; j--) {
                // If the current element is greater than the element at index j
                if (arr.get(j) > temp) {
                    // Shift the element at index j to the right
                    arr.set(j + 1, arr.get(j));
                } else {
                    // If the current element is less than or equal to the element at index j, stop shifting
                    break;
                }
            }
            // Insert the current element at the correct position
            arr.set(j + 1, temp);
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(12);
        arr.add(11);
        arr.add(13);
        arr.add(5);
        arr.add(6);

        int n = arr.size();
        insertionSort(n, arr);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
