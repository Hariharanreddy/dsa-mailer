import java.util.Scanner;

class SearchArray {

    // Function to search for a key in an array
    static boolean search(int[] arr, int size, int key) {
        // Iterate through the array
        for (int i = 0; i < size; i++) {
            // Check if the current element is equal to the key
            if (arr[i] == key) {
                // Return true if the key is found
                return true;
            }
        }
        // Return false if the key is not found
        return false;
    }

    public static void main(String[] args) {
        // Sample array
        int[] arr = {5, 7, -2, 10, 22, -2, 0, 5, 22, 1};

        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the element to search for
        System.out.println("Enter the element to search for:");
        // Read the key from the console
        int key = scanner.nextInt();

        // Call the search function to check if the key is present in the array
        boolean found = search(arr, arr.length, key);

        // Print the result
        if (found) {
            System.out.println("Key is present");
        } else {
            System.out.println("Key is absent");
        }
        scanner.close();
    }
}
