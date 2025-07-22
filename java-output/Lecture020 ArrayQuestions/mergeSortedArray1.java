import java.util.Arrays;

class MergeArrays {

    // Method to merge two sorted arrays into a third array
    static void merge(int[] arr1, int n, int[] arr2, int m, int[] arr3) {

        int i = 0, j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1
        while (i < n) {
            arr3[k++] = arr1[i++];
        }

        //Copy remaining elements from arr2. Note that in original C++ code, this part had a bug. It was copying to arr2 instead of arr3.  Corrected here.
        while (j < m) {
            arr3[k++] = arr2[j++];
        }
    }

    // Method to print an array
    static void print(int[] ans, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6};

        int[] arr3 = new int[8]; // Initialize arr3 with size 8

        merge(arr1, 5, arr2, 3, arr3);

        print(arr3, 8);
    }
}
