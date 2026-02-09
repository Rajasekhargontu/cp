class Solution {
    public int findKRotation(int arr[]) {
        int low=0,high=arr.length-1,n=arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<=arr[n-1]) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}


// APPROACH
// Use Binary search to find the index of minimum element by checking it with the last element

// COMPLEXITIES
// TIME : O(log n)
// SPACE : O(1)