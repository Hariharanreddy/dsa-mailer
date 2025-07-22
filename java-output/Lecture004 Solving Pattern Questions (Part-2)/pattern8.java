import java.util.Scanner;

public class Pattern {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int row = 1;

        while(row <= n) {

            int col = 1;
            char start = (char)('A' + n - row);
            while(col <= row) {
                System.out.print(start);
                start = (char)(start + 1);
                col = col + 1;
            }
            System.out.println();
            row = row + 1;
        }
        sc.close();
    }
}
