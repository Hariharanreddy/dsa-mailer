import java.util.Arrays;

class SumArray {

    // Recursive function to calculate the sum of elements in an array
    public int getSum(int[] arr, int size) {
        // Base case: if the array is empty, return 0
        if (size == 0) {
            return 0;
        }
        // Base case: if the array has only one element, return that element
        if (size == 1) {
            return arr[0];
        }

        // Recursive call to calculate the sum of the remaining elements
        int remainingPart = getSum(Arrays.copyOfRange(arr, 1, arr.length), size - 1);
        // Calculate the sum of the first element and the sum of the remaining elements
        int sum = arr[0] + remainingPart;
        // Return the total sum
        return sum;
    }

    public static void main(String[] args) {
        // Example array
        int[] arr = {2, 4, 9, 9, 9};
        int size = arr.length;

        // Create an instance of the SumArray class
        SumArray obj = new SumArray();
        // Calculate the sum using the recursive function
        int sum = obj.getSum(arr, size);

        // Print the sum
        System.out.println("Sum is " + sum);
    }
}
