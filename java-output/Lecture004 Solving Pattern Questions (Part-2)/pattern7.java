import java.util.Scanner;

public class Pattern {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();

        int row = 1;

        while(row <= n) {

            int col = 1;

            while(col <= row) {
                char ch = (char)('A' + row + col - 2);
                System.out.print(ch);
                col = col + 1;
            }
            System.out.println();
            row = row + 1;

        }
        sc.close();
    }
}
