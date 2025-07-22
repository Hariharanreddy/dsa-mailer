public class Main {

    public static void main(String[] args) {

        char ch = '1';
        int num = 1;

        System.out.println();
        switch (2 * num) {

            case 2:
                System.out.println("First");
                System.out.println(" First again ");
                break;

            case 49: // Note: '1' is treated as its ASCII value (49) in Java
                switch (num) {
                    case 1:
                        System.out.println(" Value of num is " + num);
                        break;
                }
                break;

            default:
                System.out.println(" It is default case");

        }

        System.out.println();

    }
}
