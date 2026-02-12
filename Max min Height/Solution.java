class Solution {
    int[] diff;
    public int maxMinHeight(int[] arr, int k, int w) {
        int n=arr.length;
        int l=Integer.MAX_VALUE,h=0;
        for(int i:arr){
            l=Math.min(l,i);
            h=Math.max(h,i);
        }
        h=h+k;
        diff=new int[n];
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isPossible(arr,k,w,mid)){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
            
        }
        return h;
    }
    public boolean isPossible(int[] arr,int days,int con,int target){
        int n=arr.length;
        diff[0]=arr[0];
        for(int i=1;i<n;i++) diff[i]=arr[i]-arr[i-1];
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=diff[i];
            if(sum<target){
                int d=target-sum;
                days-=d;
                sum+=d;
                if(i+con < arr.length)
                diff[i+con]-=d;
            }
        }
        return days>=0;
    }
}

// APPROACH
// Here we use the Binary search on Answer approach to find the solution
// First we need to find the lower and upper bounds of my answer
// The lower bound will be the minimum value in the array
// The upper bound will be the maximum value + K
// Now we do binary search in this range
// In order to check whether it possible to make minimum X , we use the concept of difference array as we need to increment a contiguous subarray of length W
// We compute the difference array and then when we have lesser value than the chosen target we just simply add some value to the subarray of size W

// COMPLEXITIES
// TIME : O(n log m)
// SPACE : O(n)