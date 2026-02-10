class Solution {
    public int kokoEat(int[] arr, int k) {
        int l=1,h=0;
        for(int i:arr) h=Math.max(h,i);
        while(l<=h){
            int mid=l+(h-l)/2;
            int req=hoursNeeded(arr,mid);
            if(req>k) l=mid+1;
            else h=mid-1;
        }
        return l;
    }
    public int hoursNeeded(int[] arr,int k){
        int ans=0;
        for(int i:arr) ans=ans+(i+k-1)/k;
        return ans;
    }
}

// APPROACH
//  To solve this question we use the binary search on answers technique.
//  low = 1 as koko can eat a minimum of 1 banana in an hour
//  high = max_pile as koko can eat each pile at once
//  at each iteration of BS we compute the no of hours taken if we choose a certain mid index
// if hours>k then we need to eat more bananas hence low=mid+1; else high=mid-1;

// COMPLEXITIES
// TIME : O(n log(max(arr)))
// SPACE : O(1)