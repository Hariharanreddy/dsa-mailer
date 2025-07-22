import java.util.Scanner;

class PowerCalculator {

    // Method to calculate power of a number
    public int power(int num1, int num2) {

        // Initialize the result to 1
        int ans = 1;

        // Iterate num2 times to calculate power
        for (int i = 1; i <= num2; i++) {
            ans = ans * num1;
        }

        //Return the calculated power
        return ans;
    }

    public static void main(String[] args) {
        //Creating an instance of PowerCalculator class
        PowerCalculator pc = new PowerCalculator();
        Scanner scanner = new Scanner(System.in);

        //Taking inputs from the user
        System.out.print("Enter the base number: ");
        int c = scanner.nextInt();
        System.out.print("Enter the exponent: ");
        int d = scanner.nextInt();

        //Calculating power using the power method of PowerCalculator class
        int answer = pc.power(c, d);

        //Printing the result
        System.out.println(" answer is " + answer);
        scanner.close();
    }
}
