class Solution {
    public int maxCircularSum(int arr[]) {
        int sum=0;
        for(int i:arr) sum+=i;
        //  First pass with kadanes algorithm for max sum
        int max=sum,total=0;
        for(int i:arr){
            if(total+i<i) total=0;
            total+=i;
            max=Math.max(max,total);
        }
       if(max < 0) return max;
        // In the case of wrap around we need to find minimum sum to delete
        total=0;
       int min=Integer.MAX_VALUE;
        for(int i:arr){
            if(total+i>i) total=0;
            total+=i;
            min=Math.min(min,total);
        }
        // System.out.println(sum+" " +min);
        return Math.max(max,sum-min);
    }
}
// APPROACH
// First find the maximum possible sum using kadane algorithm so that we can get 
// Maximum possible subarray without wrap around
// To find the maximum sum with overlap we just simply find out the minimum sum subarray
// and subtract it from total sum
// If the first pass yelds value < 0 then we dont need to go for second as all elements are -ve
// return the maximum sum  of first_pass and total-second_pass;

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(1)
