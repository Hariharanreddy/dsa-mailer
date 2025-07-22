import java.util.Arrays;

class DSACode {

    // Method to print the value pointed to by the integer pointer
    static void print(int[] p, int index) { 
        System.out.println(p[index]);
    }

    // Method to update the value pointed to by the integer pointer
    static void update(int[] p, int index) {
        p[index] = p[index] + 1;
    }

    // Method to calculate the sum of elements in an integer array
    static int getSum(int[] arr, int n) {
        System.out.println("\nSize : " + arr.length); //Note: sizeof operator doesn't work same way in java as in c++ for arrays
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8};

        System.out.println("Sum is " + getSum(Arrays.copyOfRange(arr, 3, 6), 3)); 
    }
}
