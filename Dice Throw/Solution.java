class Solution {
    static int noOfWays(int m, int n, int x) {
        int[] dp=new int[x+1];
        dp[0]=1;
        while(n>0){
            for(int i=x;i>=0;i--){
                int sum=0;
                for(int j=1;j<=m;j++){
                    if(i-j >=0 ) sum+=dp[i-j];
                }
                dp[i]=sum;
            }
            n--;
        }
        return dp[x];
    }
};

// APPROACH
// We create an auxillary to store intermediate results useful for calculating noofways(m,n,x) state space.
// At each step we move back m indices and take the sum of ways to achieve those values for the current one.
// We do this for every value upto x

// COMPLEXITIES
// TIME : O( n * m  * x )
// SPACE : O(x)