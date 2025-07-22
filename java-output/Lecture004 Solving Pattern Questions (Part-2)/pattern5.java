import java.util.Scanner;

public class Pattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner object for taking input
        int n = sc.nextInt(); //Taking the input

        int i = 1; //Outer loop counter
        while (i <= n) { //Outer loop condition

            int j = 1; //Inner loop counter
            while (j <= i) { //Inner loop condition
                System.out.print((i - j + 1) + " "); //Printing the pattern
                j = j + 1; //Incrementing inner loop counter
            }
            System.out.println(); //New line after each row
            i = i + 1; //Incrementing outer loop counter
        }
        sc.close(); //Closing Scanner object
    }
}
