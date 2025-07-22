import java.util.Arrays;

class PrintArray {

    // Method to print array elements from a given start index
    public static void print(int[] arr, int n, int start) {

        //Iterate through the array from the start index to n-1
        for (int i = start; i < n; i++) {
            System.out.println(arr[i]);
        }

    }

    //Method overloading to handle default start index of 0.
    public static void print(int[] arr, int n){
        print(arr,n,0);
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 7, 8, 9};
        int size = arr.length;

        print(arr, size);
        System.out.println();
        print(arr, size, 2);


    }
}
