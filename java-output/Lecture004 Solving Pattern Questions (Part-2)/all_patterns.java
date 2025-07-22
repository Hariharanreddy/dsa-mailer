import java.util.Scanner;

public class PatternPrinting {

    public static void pattern1() {
        // Square Pattern
        System.out.println("\nYou are going to see a square pattern:- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter side of the square:");
        int side = scanner.nextInt();
        System.out.println();

        for (int i = 1; i <= side; i++) {
            for (int j = 1; j <= side; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern2() {
        // Number Square Pattern
        System.out.println("\nYou are going to see a number square pattern:- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter side of the square:");
        int side = scanner.nextInt();
        System.out.println();

        for (int i = 1; i <= side; i++) {
            for (int j = 1; j <= side; j++) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern3() {
        // Number Square Pattern - Part 2
        System.out.println("\nYou are going to see another version of number square pattern:- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter side of the square:");
        int side = scanner.nextInt();
        System.out.println();

        for (int i = 1; i <= side; i++) {
            for (int j = 1; j <= side; j++) {
                System.out.print(j + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern4() {
        // Inverted Number Square Pattern
        System.out.println("\nYou are going to see inverted number square pattern:- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter side of the square:");
        int side = scanner.nextInt();
        System.out.println();

        for (int i = 1; i <= side; i++) {
            for (int j = 1; j <= side; j++) {
                System.out.print((side - j + 1) + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern5() {
        // Counting Square Pattern
        System.out.println("\nYou are going to see counting square pattern:- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter side of the square:");
        int side = scanner.nextInt();
        System.out.println();

        int counter = 1;
        for (int i = 1; i <= side; i++) {
            for (int j = 1; j <= side; j++) {
                System.out.print(counter + "  ");
                counter++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern6() {
        // Right Angled Triangle Pattern
        System.out.println("\nYou are going to see right angled triangle pattern:- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter height of the triangle:");
        int height = scanner.nextInt();
        System.out.println("\nEnter the symbol of which you want to create the triangle also:- ");
        char ch = scanner.next().charAt(0);
        System.out.println();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern7() {
        // Right Angled Counting Triangle Pattern
        System.out.println("\nYou are going to see right angled triangle pattern:- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter height of the triangle:");
        int height = scanner.nextInt();
        System.out.println("\nEnter the symbol of which you want to create the triangle:- ");
        char ch = scanner.next().charAt(0);
        System.out.println();

        for (int i = 1; i <= height; i++) {
            int value = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(value + " ");
                value++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern8() {
        // Right Angled Inverted Counting Triangle Pattern
        System.out.println("\nYou are going to see right angled inverted triangle pattern:- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter height of the triangle:");
        int height = scanner.nextInt();
        System.out.println();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i - j + 1 + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern9() {
        // Alphabetic Square Pattern
        System.out.println("\nYou are going to see alphabetic square pattern:- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter side of the square:-");
        int side = scanner.nextInt();
        System.out.println();

        char ch = 'A';
        for (int i = 1; i <= side; i++) {
            for (int j = 1; j <= side; j++) {
                System.out.print(ch + " ");
            }
            System.out.println();
            ch++;
        }
        System.out.println();
    }

    public static void pattern10() {
        // Alphabetic Triangle Pattern
        System.out.println("\nYou are going to see alphabetic triangle pattern:- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter height of the triangle:-");
        int height = scanner.nextInt();
        System.out.println();

        char ch = 'A';
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
            }
            System.out.println();
            ch++;
        }
        System.out.println();
    }

    public static void pattern11() {
        // Inverted Alphabetic Triangle Pattern
        System.out.println("\nYou are going to see inverted alphabetic triangle pattern:- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter height of the triangle:-");
        int height = scanner.nextInt();
        System.out.println();

        for (int i = 1; i <= height; i++) {
            char value = (char) ('A' + height - i);
            for (int j = 1; j <= i; j++) {
                System.out.print(value + "  ");
                value++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern12() {
        // Inverted Right Angle Character Triangle Pattern
        System.out.println("\nYou are going to see inverted right angle triangle character pattern:- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter height of the triangle:");
        int height = scanner.nextInt();
        System.out.println("\nEnter the symbol of which you want to create the triangle:- ");
        char ch = scanner.next().charAt(0);
        System.out.println();

        for (int i = 1; i <= height; i++) {
            for (int k = 1; k <= (height - i); k++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void pattern13() {
        // Reverse Right Angle Character Triangle Pattern
        System.out.println("\nYou are going to see reverse right angle triangle character pattern:- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter height of the triangle:- ");
        int height = scanner.nextInt();
        System.out.println("\nEnter the symbol of which you want to create the triangle:- ");
        char ch = scanner.next().charAt(0);
        System.out.println();

        for (int i = 1; i <= height; i++) {
            for (int j = height; j >= i; j--) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void pattern14() {
        // Number Pyramid Pattern
        System.out.println("\nYou are going to see a number pyramid pattern:- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter height of the pyramid:- ");
        int height = scanner.nextInt();
        System.out.println();

        for (int i = 1; i <= height; i++) {
            for (int k = 1; k <= (height - i); k++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            for (int l = i - 1; l >= 1; l--) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }

    public static void pattern15() {
        // Dabangg Pattern
        System.out.println("\nYou are going to see dabangg pattern:- ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter height of the pattern:- ");
        int height = scanner.nextInt();
        System.out.println();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= (height - i + 1); j++) {
                System.out.print(j + " ");
            }
            for (int k = 1; k <= (i - 1); k++) {
                System.out.print("* ");
            }
            for (int k = (i - 1); k >= 1; k--) {
                System.out.print("* ");
            }
            for (int l = (height - i + 1); l >= 1; l--) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSelect which pattern you want to print from below list:\n");
        System.out.println("\n1. Square Pattern.");
        System.out.println("\n2. Number Square Pattern.");
        System.out.println("\n3. Another Number Square Pattern.");
        System.out.println("\n4. Inverted Number Square Pattern.");
        System.out.println("\n5. Counting Square Pattern.");
        System.out.println("\n6. 90 Degree Triangle Pattern.");
        System.out.println("\n7. 90 Degree Counting Triangle Pattern.");
        System.out.println("\n8. 90 Degree Inverted Counting Triangle Pattern.");
        System.out.println("\n9. Alphabetic Square Pattern.");
        System.out.println("\n10. Alphabetic Triangle Pattern.");
        System.out.println("\n11. Inverted Alphabetic Triangle Pattern.");
        System.out.println("\n12. Right Angle Inverted Character Triangle Pattern.");
        System.out.println("\n13. Right Angle Reverse Character Triangle Pattern.");
        System.out.println("\n14. Number Pyramid Pattern.");
        System.out.println("\n15. Dabangg Pattern.");
        System.out.println("\nEnter your choice: ");
        int choice = scanner.nextInt();
        System.out.println();

        switch (choice) {
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
            case 5:
                pattern5();
                break;
            case 6:
                pattern6();
                break;
            case 7:
                pattern7();
                break;
            case 8:
                pattern8();
                break;
            case 9:
                pattern9();
                break;
            case 10:
                pattern10();
                break;
            case 11:
                pattern11();
                break;
            case 12:
                pattern12();
                break;
            case 13:
                pattern13();
                break;
            case 14:
                pattern14();
                break;
            case 15:
                pattern15();
                break;
            default:
                System.out.println("Invalid Number, please select a number from above given list :)");
                System.out.println();
        }
        scanner.close();
    }
}
