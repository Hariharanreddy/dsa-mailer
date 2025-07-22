import java.util.Scanner;

public class Counting {

    //Function Signature
    public static void printCounting(int num) {
        //Function Body 
        for(int i=1; i<=num; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Enter the number: ");
        n = scanner.nextInt();

        //function Call
        printCounting(n);
        scanner.close();
    }
}
