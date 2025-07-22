public class ReachHome {

    // Method to simulate reaching home recursively
    public static void reachHome(int src, int dest) {

        System.out.println("source " + src + " destination " + dest);
        // Base case: If source equals destination, we've reached home
        if (src == dest) {
            System.out.println(" pahuch gya ");
            return;
        }

        // Processing: Move one step closer to the destination
        src++;

        // Recursive call: Repeat the process from the new source
        reachHome(src, dest);

    }

    public static void main(String[] args) {

        int dest = 10;
        int src = 1;

        System.out.println();

        reachHome(src, dest);


    }
}
