import java.util.Scanner;

public class PatternPrinter {

    public static void pattern1() {
        // Inverted & Reverse Same Number Triangle Pattern
        System.out.println("\nYou are going to see a inverted & reverse same number triangle pattern (H.W-1):- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter height of the triangle:- ");
        int height = scanner.nextInt();

        int value = 1;
        for (int i = 1; i <= height; i++) {
            for (int k = 1; k <= i; k++) {
                System.out.print("  ");
            }
            for (int j = height; j >= i; j--) {
                System.out.print(value + " ");
            }
            System.out.println();
            value++;
        }
        System.out.println();
    }

    public static void pattern2() {
        // Inverted Same Number Triangle Pattern
        System.out.println("\nYou are going to see a inverted same number triangle pattern (H.W-2):- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter height of the triangle:- ");
        int height = scanner.nextInt();

        int value = 1;
        for (int i = 1; i <= height; i++) {
            for (int k = 1; k <= (height - i); k++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(value + " ");
            }
            System.out.println();
            value++;
        }
        System.out.println();
    }

    public static void pattern3() {
        // Continuous Number Triangle Pattern
        System.out.println("\nYou are going to see a inverted continuous number triangle pattern (H.W-3):- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter height of the triangle:- ");
        int height = scanner.nextInt();

        int value = 1;
        for (int i = 1; i <= height; i++) {
            for (int k = 1; k <= (height - i); k++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(value + " ");
                value++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern4() {
        // Continuous Number Triangle Pattern
        System.out.println("\nYou are going to see a inverted & reverse continuous number triangle pattern (H.W-4):- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter height of the triangle:- ");
        int height = scanner.nextInt();

        for (int i = 1; i <= height; i++) {
            int value = 1;
            for (int k = 1; k <= i; k++) {
                System.out.print("  ");
            }
            for (int j = height; j >= i; j--) {
                System.out.print(value + " ");
                value++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSelect which pattern you want to print from below list:\n");
        System.out.println("\n1. Inverted & Reverse Same Number Triangle Pattern (H.W-1).");
        System.out.println("\n2. Inverted Same Number Triangle Pattern (H.W-2).");
        System.out.println("\n3. Inverted Continuous Number Triangle Pattern (H.W-3).");
        System.out.println("\n4. Inverted & Reverse Number Triangle Pattern (H.W-4).");
        System.out.println("\n");
        int patternNumber = scanner.nextInt();

        switch (patternNumber) {
            case 1:
                pattern1();
                break;
            case 2:
                pattern2();
                break;
            case 3:
                pattern3();
                break;
            case 4:
                pattern4();
                break;
            default:
                System.out.println("Invalid Number, please select a number from above given list :)\n");
        }
        scanner.close();
    }
}
