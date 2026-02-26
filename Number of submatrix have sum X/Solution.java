class Solution {
    public int countSquare(int[][] mat, int x) {
       int m=mat.length,n=mat[0].length;
       int[][] psum=new int[m][n];
       for(int i=0;i<m;i++){
           int sum=0;
           for(int j=0;j<n;j++){
               sum+=mat[i][j];
               psum[i][j]=sum;
               if(i>0) psum[i][j]+=psum[i-1][j];
           }
       }
       int ans=0;
       for(int k=1;k<=Math.min(n,m);k++){
           for(int i=0;i<=m-k;i++){
               for(int j=0;j<=n-k;j++){
                   int sum=psum[i+k-1][j+k-1];
                   if(i>0 && j>0) sum+=psum[i-1][j-1];
                   if(i>0) sum-=psum[i-1][j+k-1];
                   if(j>0) sum-=psum[i+k-1][j-1];
                   if(sum==x) ans++;
               }
           }
       }
       return ans;
    }
}

// APPROACH
// We use the prefix sum concept to compute the sum of any square subarray in O(1) time
// Here we first build an auxillary psum matrix which stores the sum of all elements that are on the top left side of current positions
// We iterate on posssible subarray sizes i.e. from 0 to Min(m,n) and for each value:
//      Traverse the matrix and find the sum of each square sub matrix of size k and update answer;
//  The subarray sum is calculated as if (i,j) is top-left and (i+k,j+k) is bottom-right:
//  sum upto (i+k,j+k) - sum upto (i-1,j+k) - sum upto (i+k,j-1) + sum upto (i-1,j-1)

// COMPLEXITIES
// TIME : O(m * n * min(n,m))
// SPACE : O(m * n)