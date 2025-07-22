public class StairClimbing {

    // Recursive function to count distinct ways to climb stairs
    public int countDistinctWayToClimbStair(long nStairs) {
        // Base case: If nStairs is negative, there are no ways to climb
        if (nStairs < 0) {
            return 0;
        }
        // Base case: If nStairs is 0, there is one way to climb (do nothing)
        if (nStairs == 0) {
            return 1;
        }
        // Recursive case: The total number of ways is the sum of ways to reach nStairs-1 and nStairs-2
        int ans = countDistinctWayToClimbStair((int)(nStairs - 1)) + countDistinctWayToClimbStair((int)(nStairs - 2));
        return ans;
    }

    public static void main(String[] args) {
        StairClimbing sc = new StairClimbing();
        long n = 5; // Example number of stairs
        int ways = sc.countDistinctWayToClimbStair(n);
        System.out.println("Number of distinct ways to climb " + n + " stairs: " + ways);
    }
}
