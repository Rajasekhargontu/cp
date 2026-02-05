class Solution {
    public int maxOnes(int arr[], int k) {
        int l=0,r=0,cnt=0,max=0;
        while(r<arr.length){
            if(arr[r]==0) cnt++;
            if(cnt>k){
                while(arr[l]!=0) l++;
                cnt--;
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}

// APPRAOCH
// We use the sliding window approach here
// Initialize l that holds the starting index of the window and r the last index of window
// We count the number of 0s in the window and if its > k we move l to just after the first 0
// take the maximum length among all possible l & r values


// COMPLEXITIES
// TIME : O(n)
// SPACE : O(1)