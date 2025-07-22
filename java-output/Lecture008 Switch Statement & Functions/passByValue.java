import java.util.Scanner;

class Main {

    // Dummy method to increment and print the value of n
    static void dummy(int n) {
        n++;
        System.out.println(" n is " + n);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Scanner for taking input from the user

        int n;
        System.out.print("Enter the value of n: "); // prompt the user to enter a value for n
        n = input.nextInt(); // read the value of n from the user

        dummy(n); // call the dummy method to increment and print n

        System.out.println("number n is " + n); // print the original value of n

        input.close(); // close the scanner
    }
}
