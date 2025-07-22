import java.util.Scanner;

public class Pattern {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //Scanner object to take input from user
        int n = sc.nextInt(); //Taking input from user

        int i = 1;

        while(i<=n) { //Outer loop for rows

            int j = 1;
            while(j<=n) { //Inner loop for columns
                System.out.print("*"); //Printing * for each column
                j = j+1; 
            }
            System.out.println(); //Moving to next line after each row

            i = i+1;
        } 
        sc.close(); //Closing the scanner object
    }
}
