import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseArray {

    // Method to reverse an array list
    public static List<Integer> reverse(List<Integer> v) {
        int s = 0, e = v.size() - 1;
        while (s <= e) {
            // Swapping elements using Collections.swap
            Collections.swap(v, s, e);
            s++;
            e--;
        }
        return v;
    }

    // Method to print the array list
    public static void print(List<Integer> v) {
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating an ArrayList of Integers
        List<Integer> v = new ArrayList<>();
        v.add(11);
        v.add(7);
        v.add(3);
        v.add(12);
        v.add(4);

        // Reversing the array list
        List<Integer> ans = reverse(v);

        System.out.println("Printing reversed array:");
        print(ans);
    }
}
