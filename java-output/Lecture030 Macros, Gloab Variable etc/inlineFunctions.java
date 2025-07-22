import java.lang.*;

class Main{

    //Inline function to get the maximum of two integers.
    static int getMax(int a, int b){
        return (a>b) ? a : b;
    }

    public static void main(String[] args){

        int a = 1, b = 2;
        int ans = 0;

        ans = getMax(a,b);
        System.out.println(ans);

        a = a + 3;
        b = b + 1;

        ans = getMax(a,b);
        System.out.println(ans);

    }
}
