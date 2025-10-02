class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int ans = numBottles;
        if(numExchange>numBottles) return ans;
        int rem = numBottles%numExchange;
        int remBottle = numBottles;
        while(remBottle>=numExchange){
            rem = remBottle%numExchange;
            int div = remBottle/numExchange;
            ans += div;
            remBottle = div+rem;
            

        }
        return ans;
    }
}