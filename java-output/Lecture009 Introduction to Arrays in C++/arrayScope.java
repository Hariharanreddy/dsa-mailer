import java.util.Arrays;

class Main {

    // Java equivalent of the C++ update function
    public static void update(int[] arr, int n) {

        System.out.println("\nInside the function");

        // Updating the array's first element
        arr[0] = 120;

        // Printing the array
        System.out.println(Arrays.toString(arr));


        System.out.println("Going back to main function");
    }


    public static void main(String[] args) {

        //initializing the array
        int[] arr = {1, 2, 3};

        //calling the update function
        update(arr, 3);

        // Printing the array in the main function
        System.out.println("\nPrinting in main function");
        System.out.println(Arrays.toString(arr));
    }
}
