public class Main {

    public static void main(String[] args) {

        int a = 4;
        int b = 6;

        System.out.println("a&b " + (a&b));
        System.out.println("a|b " + (a|b));
        System.out.println("~a " + (~a));
        System.out.println("a^b " + (a^b));

        System.out.println((17>>1));
        System.out.println((17>>2));
        System.out.println((19<<1));
        System.out.println((21<<2));

        int i = 7;

        System.out.println(++i); // 8
        System.out.println(i++); // 8, i = 9
        System.out.println(i--); // 9, i = 8
        System.out.println(--i); // 7, i = 7

    }
}
