class Solution {
    int findWays(int n) {
        if(n%2 == 1) return 0;
        long ways=1;
        for(int i=n;i>n/2+1;i--) ways=ways*i;
        for(int i=n/2;i>1;i--) ways=ways/i;
        return (int)ways;
    }
    int findWays2(int n){
        if(n%2 == 1 || n==0) return 0;
        return countValid(n/2,n/2);
    }
    private int countValid(int open, int close) {
        if(close < open) return 0;
        if(open==1) return 1;
        return countValid(open-1,close)+countValid(open,close-1);
    }
    @SuppressWarnings("unused")
    private int findWaysDp(int n){
        if (n % 2 == 1)
            return 0;        
        int pairs = n / 2;
        int[][] dp = new int[pairs + 1][pairs + 1];    
        for (int close = 0; close <= pairs; close++) {
            dp[0][close] = 1;
        }
        for (int open = 1; open <= pairs; open++) {            
            // valid only if closes left ≥ opens left
            for (int close = open; close <= pairs; close++) {  
                dp[open][close] = dp[open-1][close] + dp[open][close-1];
            }
        }        
        return dp[pairs][pairs];
    }
}

// APPROACH
// We Know that the number of valid parentheses that can be generated is given by thhe Catalan Number
//                          count= (2n C n) / (n+1)
// COMPLEXITIES
// TIME : O(n)
// SPACE : O(1)
