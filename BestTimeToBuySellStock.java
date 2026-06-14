class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int currPrice = prices[0];
        for(int num: prices){
            if(num < currPrice) currPrice = num;
            else if(num - currPrice > profit) profit = num - currPrice;
        }
        return profit;
    }
}
