class Solution {
    void pushZerosToEnd(int[] arr) {
       int left=0,right=0;
       while(right<arr.length){
           if(arr[right]!=0){
               arr[left++]=arr[right];
           }
           right++;
       }
       while(left<arr.length) arr[left++]=0;
    }
}

// APPROACH
// We traverse from left to right and track the index where the next non zero element is to be placed
// Whenever we find a non zero element we update the left index and increment it
// Make the remaining indeices zero.

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(1)