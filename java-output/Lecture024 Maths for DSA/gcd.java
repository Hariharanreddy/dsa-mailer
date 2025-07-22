import java.util.Scanner;

class GCD {

    // Function to compute the greatest common divisor (GCD) of two integers using Euclid's algorithm
    public int gcd(int a, int b) {

        // Base cases: if either a or b is 0, the GCD is the other number
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        // Iterative approach: subtract the smaller number from the larger number until they are equal
        while (a != b) {

            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a; // or b, since they are equal at this point
    }

    public static void main(String[] args) {

        GCD obj = new GCD(); //Creating an object of the class
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the values of a and b");
        int a = input.nextInt();
        int b = input.nextInt();

        int ans = obj.gcd(a, b); //Calling the gcd function

        System.out.println("The GCD of " + a + " & " + b + " is: " + ans);

        input.close(); //closing scanner object
    }
}
