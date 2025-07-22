import java.util.Arrays;

class Solution {
    // Function to check if it is possible to allocate books to students with given constraints
    boolean isPossible(int[] arr, int n, int m, int mid) {
        int studentCount = 1;
        int pageSum = 0;
        //cout << "checking for mid "<< mid <<endl;

        for (int i = 0; i < n; i++) {
            if (pageSum + arr[i] <= mid) {
                pageSum += arr[i];
            } else {
                studentCount++;
                if (studentCount > m || arr[i] > mid) {
                    return false;
                }
                pageSum = arr[i];
            }
            if (studentCount > m) {
                return false;
            }
            //cout << " for i " << i << " Student "<< studentCount << " pageSum " << pageSum << endl;
        }
        return true;
    }

    // Function to find the minimum maximum pages allocated to a student
    int allocateBooks(int[] arr, int n, int m) {
        int s = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int e = sum;
        int ans = -1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            if (isPossible(arr, n, m, mid)) {
                //cout<<" Mid returned TRUE" << endl;
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] arr = {10, 20, 30, 40};
        int n = arr.length;
        int m = 2;
        int result = obj.allocateBooks(arr, n, m);
        System.out.println("Minimum maximum pages allocated: " + result);
    }
}
