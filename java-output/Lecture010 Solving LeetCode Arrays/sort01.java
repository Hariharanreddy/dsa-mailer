import java.util.Arrays;

class SortArray {

    // Function to print the array
    static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Function to sort the array with 0s and 1s
    static void sortOne(int[] arr, int n) {
        int left = 0, right = n - 1;

        while (left < right) {

            while (arr[left] == 0 && left < right) {
                left++;
            }

            while (arr[right] == 1 && left < right) {
                right--;
            }

            // If left < right, it means arr[left] == 1 and arr[right] == 0
            if (left < right) {
                //Swap elements
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 0, 0, 1, 0};

        System.out.println("Original array: " + Arrays.toString(arr));
        sortOne(arr, 8);
        System.out.println("Sorted array: ");
        printArray(arr, 8);
    }
}
