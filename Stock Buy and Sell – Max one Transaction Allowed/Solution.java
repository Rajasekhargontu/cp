class Solution {
    public int maxProfit(int[] prices) {
        int max=0,ans=0;
        for(int i=prices.length-1;i>=0;i--){
            ans=Math.max(ans,max-prices[i]);
            max=Math.max(max,prices[i]);
        }
        return ans;
    }
}

// APPROACH
// We traverse the array from right to left and maintain the maximum selling price we can have.
// we update the maximum profit assuming how much profit i get if i sell today and take maximum

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(1)