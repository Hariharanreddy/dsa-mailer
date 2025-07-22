import java.util.Scanner;

public class Pattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the number of rows: ");
        n = sc.nextInt();

        int row = 1;

        while(row<=n) {

            int col = 1;
            int value = row;
            while(col <= row) {
                System.out.print(value);
                value = value + 1;
                col = col + 1;
            }
            System.out.println();
            row = row + 1;
        }
        sc.close();
    }
}
