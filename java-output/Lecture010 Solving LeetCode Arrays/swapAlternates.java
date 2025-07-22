import java.util.Arrays;

class SwapAlternate {

    // Method to print the array
    static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Method to swap alternate elements of the array
    static void swapAlternate(int[] arr, int size) {
        for (int i = 0; i < size; i += 2) {
            if (i + 1 < size) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] even = {5, 2, 9, 4, 7, 6, 1, 0};
        int[] odd = {11, 33, 9, 76, 43};

        swapAlternate(even, 8);
        printArray(even, 8);

        System.out.println();

        swapAlternate(odd, 5);
        printArray(odd, 5);
    }
}
