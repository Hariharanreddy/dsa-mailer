import java.util.Arrays;
import java.util.Scanner;

class FindMinMax {

    // Method to find the minimum element in an array
    public int getMin(int[] num, int n) {
        int mini = Integer.MAX_VALUE; // Initialize mini with the maximum possible integer value

        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, num[i]); // Use Math.min() to find the minimum between mini and num[i]
        }

        //returning min value
        return mini;
    }

    // Method to find the maximum element in an array
    public int getMax(int[] num, int n) {
        int maxi = Integer.MIN_VALUE; // Initialize maxi with the minimum possible integer value

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, num[i]); // Use Math.max() to find the maximum between maxi and num[i]
        }

        //returning max value
        return maxi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();


        int[] num = new int[100]; // Declare an array of size 100

        //taking input in array
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            num[i] = sc.nextInt();
        }

        FindMinMax obj = new FindMinMax(); //creating object of class
        System.out.println(" Maximum value is " + obj.getMax(num, size));
        System.out.println(" Minimum value is " + obj.getMin(num, size));
        sc.close();
    }
}
