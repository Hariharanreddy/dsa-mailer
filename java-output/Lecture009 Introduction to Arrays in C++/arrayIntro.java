```java
class ArrayOperations {

    // Method to print array elements
    static void printArray(int[] arr, int size) {

        System.out.println(" printing the array ");
        // Print array elements
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" printing DONE ");
    }

    public static void main(String[] args) {

        // Declare an integer array
        int[] number = new int[15];

        // Accessing array elements (Note: accessing beyond bounds may throw an exception)
        System.out.println("Value at 14 index " + number[14]);

        // System.out.println("Value at 20 index " + number[20]); // This will throw an exception

        // Initializing an array
        int[] second = {5, 7, 11};

        // Accessing an element
        System.out.println("Value at 2 index " + second[2]);

        int[] third = {2, 7};

        int n = 15;
        //printArray(third, 15);
        int thirdSize = third.length;
        System.out.println(" Size of Third is " + thirdSize);

        // Initializing all locations with 0
        int[] fourth = new int[10];

        n = 10;
        //printArray(fourth, 10);

        // Initializing all locations with 1 (Note: Java handles this differently)
        int[] fifth = new int[10];
        java.util.Arrays.fill(fifth,1);

        n = 10;
        //printArray(fifth, 10);

        int fifthSize = fifth.length;
        System.out.println(" Size of Fifth is " + fifthSize);


        char[] ch = {'a', 'b', 'c', 'r', 'p'};
        System.out.println(ch[3]);

        System.out.println(" printing the array ");
        // Print array elements
        for (int i = 0; i < 5; i++) {
            System.out.print(ch[i] + " ");
        }
        System.out.println(" printing DONE ");

        double[] firstDouble = new double[5];
        float[] firstFloat = new float[6];
        boolean[] firstBool = new boolean[9];


        System.out.println("\n Everything is Fine \n");

    }
}
```
