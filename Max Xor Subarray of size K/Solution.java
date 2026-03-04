class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int max=0,curr=0;
        for(int i=0;i<arr.length;i++){
            if(i>=k){
                max=Math.max(max,curr);
                curr=curr^arr[i-k];
            }
            curr=curr^arr[i];
        }
        max=Math.max(max,curr);
        return max;
    }
}

// APPROACH
// We use sliding window technique by removing leftmost element from each subarray of size k and add the right most element


// COMPLEXITIES
// TIME : O(n)
// SPACE : O(1)