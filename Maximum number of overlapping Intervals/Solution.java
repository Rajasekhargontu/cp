class Solution {
    public static int overlapInt(int[][] arr) {
        int n=0;
        for(int[] x:arr) n=Math.max(x[1],n);
        n+=2;
        int[] psum=new int[n];
        for(int[] x:arr){
            psum[x[0]]++;
            psum[x[1]+1]--;
        }
        int ans=0,sum=0;
        for(int i:psum){
            sum+=i;
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}

// APPROACH
// In order to find out the maximum number of intervals at any instant of time we do the following:
// We need to find the number of intervals active at any instant of time.
// To find this we use prefix sum concept
// we initialize an array large enough i.e. max(end+2)
// for each interval we increment 1 at the start of interval and decrement one at the next instant of end
// We scan the array l to r take cumulative sum and maximum of the values is the answer

// COMPLEXITIES
// TIME : O(max(intervals[end]))
// SPACE : O(max(intervals[end]))