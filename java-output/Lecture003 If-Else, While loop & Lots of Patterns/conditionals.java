import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //int a;
        //Scanner sc = new Scanner(System.in);
        //a = sc.nextInt();

        //System.out.println(" value of n is :" + a);

        //if a is positive
        /*
        if(a>0) {
            System.out.println(" A is Positive");
        } else {
            System.out.println(" A is negative");
        }


        int a,b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a ");
        a = sc.nextInt();
        System.out.println("Enter the value of b ");
        b = sc.nextInt();

        if(a>b) {
            System.out.println(" A is greater ");
        }
        if(b>a) {
            System.out.println(" B is greater ");
        }

        */

        Scanner sc = new Scanner(System.in);
        int a;
        System.out.println(" enter the value of a ");
        a = sc.nextInt();

        if(a>0) {
            System.out.println(" A is positive");
        } else if(a<0) {
            System.out.println(" A is negative");
        } else {
            System.out.println(" A is 0");
        }

        sc.close();
    }
}
