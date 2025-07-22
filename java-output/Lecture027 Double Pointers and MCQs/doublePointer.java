```java
class Solution {
    // Method to modify the value pointed to by a double pointer
    void update(Integer[][] p2) {
        //p2 = p2 + 1; //This will not change the original value
        //*p2 = *p2 + 1; //This will change the original value
        p2[0][0] = p2[0][0] + 1; //This will change the original value
    }

    // Method to double the value pointed to by a single pointer
    void update(Integer p) {
        p = p * 2;
    }

    // Method to increment the value pointed to by a double pointer
    void increment(Integer[][] p) {
        p[0][0]++;
    }

    public static void main(String[] args) {
        /*
        int i = 5;
        Integer p = i;
        Integer[][] p2 = {{p}};

        System.out.println("\n\n Sab sahi chal rha h \n\n");

        System.out.println(i);
        System.out.println(p);
        System.out.println(p2[0][0]);

        System.out.println(Integer.toHexString(System.identityHashCode(i)));
        System.out.println(Integer.toHexString(System.identityHashCode(p)));
        System.out.println(Integer.toHexString(System.identityHashCode(p2[0][0])));

        System.out.println(Integer.toHexString(System.identityHashCode(p)));
        System.out.println(Integer.toHexString(System.identityHashCode(p2)));

        System.out.println("\n\n");
        System.out.println("before " + i);
        System.out.println("before " + p);
        System.out.println("before " + p2[0][0]);
        Solution obj = new Solution();
        obj.update(p2);
        System.out.println("after " + i);
        System.out.println("after " + p);
        System.out.println("after " + p2[0][0]);
        System.out.println("\n\n");
        */

        int num = 110;
        Integer ptr = num; // Autoboxing
        Integer[][] ptr2 = {{ptr}};
        Solution obj = new Solution();
        obj.increment(ptr2);
        System.out.println(ptr);


    }
}
```
