import java.util.Scanner;

class EvenOddChecker {

    // 1 -> Even
    // 0 -> Odd
    boolean isEven(int a) {
        // Odd
        if ((a & 1) == 1) {
            return false;
        } else { // Even
            return true;
        }
    }

    public static void main(String[] args) {
        EvenOddChecker checker = new EvenOddChecker();
        Scanner scanner = new Scanner(System.in);
        int num;
        System.out.print("Enter a number: ");
        num = scanner.nextInt();
        scanner.close();

        if (checker.isEven(num)) {
            System.out.println("Number is Even");
        } else {
            System.out.println("Number is Odd");
        }
    }
}
