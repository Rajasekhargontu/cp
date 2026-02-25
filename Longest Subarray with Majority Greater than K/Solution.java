import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0,ans=0;
        map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k) sum--;
            else sum++;
            if(sum<=0 && map.containsKey(sum-1)) ans=Math.max(ans,i-map.get(sum-1));
            else if(sum>0) ans=i+1;
            if(!map.containsKey(sum)) map.put(sum,i);
        }
        return ans;
    }
}


// APPROACH
// Here take a variable sum and increment it current value is <= k else increment it.
// We store the first occurences of every unique sum in a hashmap
// Whenever the sum goes <= 0 we check in the map for sum+1 and calculate the length of longest needed such subarray
// Whenever sum > 0 we just simply update answer to length upto current index
// Return the maximum of all the lengths

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(n)