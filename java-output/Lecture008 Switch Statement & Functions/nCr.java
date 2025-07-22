import java.util.Scanner;

class Combinations {

    // Method to calculate factorial of a number
    static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    // Method to calculate nCr (n choose r)
    static int nCr(int n, int r) {
        int num = factorial(n);
        int denom = factorial(r) * factorial(n - r);
        return num / denom;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, r;
        System.out.print("Enter n and r: ");
        n = sc.nextInt();
        r = sc.nextInt();
        System.out.println("Answer is " + nCr(n, r));
        sc.close();
    }
}
