import java.util.Scanner;

public class PrimeChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int i = 2;

        while (i < n) {
            //divisible, not prime
            if (n % i == 0) {
                System.out.println("Not prime for " + i);
            } else {
                System.out.println("Prime for " + i);
            }
            i = i + 1;
        }

    }
}
