import java.util.Scanner;

public class DSACode {

    public static void main(String[] args) {

        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the value of n");
        n = scanner.nextInt(); //Reading input from console

        System.out.println("printing count from 1 to n");
        int i = 1;
        for (;;) {
            if (i <= n) {
                System.out.println(i);
            } else {
                break;
            }
            i++;
        }


        for (int a = 0, b = 1, c = 2; a >= 0 && b >= 1 && c >= 2; a--, b--, c--) {
            System.out.println(a + " " + b + " " + c);
        }
        scanner.close(); // closing the scanner
    }
}
