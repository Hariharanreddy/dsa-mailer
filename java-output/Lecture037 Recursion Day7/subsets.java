import java.util.ArrayList;
import java.util.List;

class Solution {
    private void solve(List<Integer> nums, List<Integer> output, int index, List<List<Integer>> ans) {
        //base case
        if(index >= nums.size()) {
            ans.add(new ArrayList<>(output)); //Added a new ArrayList to avoid modifying the original output list.
            return ;
        }
        
        //exclude
        solve(nums, output, index+1, ans);
        
        //include
        int element = nums.get(index);
        output.add(element);
        solve(nums, output, index+1, ans);
        
    }
    
    public List<List<Integer>> subsets(List<Integer> nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        solve(nums, output, index, ans);
        return ans;
        
    }
}
