import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Create a Scanner object to read input

        int a, b;

        System.out.print("Enter the value of a: "); // Prompt for input a
        a = input.nextInt(); // Read integer input for a

        System.out.print("Enter the value of b: "); // Prompt for input b
        b = input.nextInt(); // Read integer input for b


        char op;
        System.out.print("Enter the operation you want to perform (+, -, *, /, %): "); //Prompt for the operation
        op = input.next().charAt(0); //Read the operation character

        switch (op) {

            case '+':
                System.out.println(a + b); //Print the sum
                break;

            case '-':
                System.out.println(a - b); //Print the difference
                break;

            case '*':
                System.out.println(a * b); //Print the product
                break;

            case '/':
                System.out.println(a / b); //Print the quotient
                break;

            case '%':
                System.out.println(a % b); //Print the remainder
                break;

            default:
                System.out.println("Please enter a valid operation"); //Print error message if invalid operation

        }
        input.close(); //Close the scanner to prevent resource leak.

    }
}
