class Solution {
    public int maxWater(int arr[]) {
        int l=0,lmax=0,r=arr.length-1,rmax=arr.length-1,ans=0;
        while(l<=r){
            if(arr[lmax]<=arr[l]) lmax=l;
            if(arr[rmax]<=arr[r]) rmax=r;
            if(arr[lmax]<arr[rmax]){
                ans+=arr[lmax]-arr[l];
                l++;
            }
            else{
                ans+=arr[rmax]-arr[r];
                r--;
            }
        }
        return ans;
    }
}

// APPROACH
// We need to keep track of the maximum values to the left and right of each index.
// We update pointers based on which side has the smaller maximum value

// COMMPLEXITIES
// TIME : O(n)
// SPACE : O(1)