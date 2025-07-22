import java.util.Scanner;

public class Pattern {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //Input n from the user

        int i = 1;

        while(i <= n) { // Outer loop for rows

            int j = 1;
            while(j <= n) { //Inner loop for columns
                System.out.print(i); //Print the row number
                j = j + 1;
            }
            System.out.println(); // Move to the next line after each row
            i = i + 1;
        }
        sc.close();
    }
}
