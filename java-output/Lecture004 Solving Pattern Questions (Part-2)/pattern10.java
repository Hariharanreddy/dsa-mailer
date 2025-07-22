import java.util.Scanner;

public class Pattern {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the value of n: ");
        n = sc.nextInt();

        int row = 1;

        while(row <= n) {

            //Print spaces (1st triangle)
            int space = n - row ;
            while(space > 0) {
                System.out.print(" ");
                space--;
            }

            //print 2nd triangle 
            int j = 1;
            while(j <= row ) {
                System.out.print(j);
                j++;
            }

            //print 3rd triangle

            int start = row - 1;
            while(start > 0) {
                System.out.print(start);
                start--;
            }

            System.out.println();
            row++;
        }
        sc.close();
    }
}
