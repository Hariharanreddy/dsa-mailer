import java.util.Scanner;

public class Pattern {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int row = 1;

        while(row <= n) {

            // Print spaces
            int space = n - row;
            while(space > 0) {
                System.out.print(" ");
                space--;
            }

            // Print stars
            int col = 1;
            while( col <= row ) {
                System.out.print("*");
                col++;
            }
            System.out.println();
            row++;
        }
        sc.close();
    }
}
