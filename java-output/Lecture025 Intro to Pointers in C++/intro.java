public class Main {
    public static void main(String[] args) {
        int num = 5;

        System.out.println(num);

        // address of Operator - &  (Java doesn't directly expose memory addresses like C++)

        //System.out.println("address of num is " + Integer.toHexString(System.identityHashCode(num))); //Approximation using identityHashCode

        int[] numArray = new int[1];
        numArray[0] = num;
        int ptr = numArray[0]; // Java uses references, not direct pointers

        System.out.println("Address is (approximation): " + Integer.toHexString(System.identityHashCode(numArray))); //Approximation
        System.out.println("value is : " + ptr);


        double d = 4.3;
        double[] dArray = new double[1];
        dArray[0] = d;
        double p2 = dArray[0];  // Java uses references, not direct pointers


        System.out.println("Address is (approximation): " + Integer.toHexString(System.identityHashCode(dArray))); //Approximation
        System.out.println("value is : " + p2);

        System.out.println("size of integer is " + Integer.BYTES);
        System.out.println("size of pointer is " + Integer.BYTES); // Size of reference (pointer equivalent) in Java
        System.out.println("size of pointer is " + Double.BYTES); // Size of double reference (pointer equivalent) in Java

    }
}
