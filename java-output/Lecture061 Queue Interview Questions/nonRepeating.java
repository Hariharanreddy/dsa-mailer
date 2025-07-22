import java.util.*;
import java.lang.*;

class Solution{
    public String FirstNonRepeating(String A){
        Map<Character, Integer> m = new HashMap<>();
        String ans = "";
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<A.length(); i++) {
            char ch = A.charAt(i);

            q.offer(ch);
            m.put(ch, m.getOrDefault(ch, 0) + 1);

            while(!q.isEmpty()) {
                if(m.get(q.peek()) > 1){
                    q.poll();
                }
                else
                {
                    ans += q.peek();
                    break;
                }
            }
            if(q.isEmpty()){
                ans += '#';
            }
        }
        return ans;
    }
}

class DriverClass{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0){
            String A = sc.next();
            Solution obj = new Solution();
            String ans = obj.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
