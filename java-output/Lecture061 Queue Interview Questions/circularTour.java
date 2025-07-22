import java.util.*;
class petrolPump{
    int petrol;
    int distance;
    petrolPump(int petrol, int distance){
        this.petrol = petrol;
        this.distance = distance;
    }
}
class Solution{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(petrolPump p[],int n)
    {
        int deficit = 0;
        int balance = 0;
        int start = 0;

        for(int i=0; i<n; i++) {
            balance += p[i].petrol - p[i].distance;
            if(balance < 0) {
                start = i+1;
                deficit += balance;
                balance = 0;
            }
        }

        if(balance + deficit >=0) 
            return start;
        return -1;

    }
}
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            petrolPump[] p = new petrolPump[n];
            for(int i=0; i<n; i++){
                int petrol = sc.nextInt();
                int distance = sc.nextInt();
                p[i] = new petrolPump(petrol, distance);
            }
            Solution obj = new Solution();
            System.out.println(obj.tour(p,n));
        }
    }
}
