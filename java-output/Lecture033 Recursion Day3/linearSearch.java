import java.util.Arrays;

class DSA {

    // Method to print the array
    public void print(int[] arr, int n) {
        System.out.println("Size of array is " + n);
        System.out.println(Arrays.toString(arr));
    }

    // Recursive linear search function
    public boolean linearSearch(int[] arr, int size, int k) {
        print(arr, size); // Print the array at each recursive call
        // Base case: if the array is empty, the element is not present
        if (size == 0) {
            return false;
        }
        // If the first element is equal to the key, return true
        if (arr[0] == k) {
            return true;
        } else {
            // Recursively call the function on the remaining part of the array
            int[] remainingPart = Arrays.copyOfRange(arr, 1, arr.length);
            return linearSearch(remainingPart, size - 1, k);
        }
    }

    public static void main(String[] args) {
        DSA obj = new DSA(); //creating object of class
        int[] arr = {3, 5, 1, 2, 6};
        int size = arr.length;
        int key = 6;
        boolean ans = obj.linearSearch(arr, size, key);

        if (ans) {
            System.out.println("Present");
        } else {
            System.out.println("Absent");
        }
    }
}
