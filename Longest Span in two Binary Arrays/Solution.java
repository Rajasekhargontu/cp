import java.util.HashMap;

class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0,sum=0;
        map.put(0,-1);
        for(int i=0;i<a1.length;i++){
            sum+=(a1[i]-a2[i]);
            if(map.containsKey(sum))
                ans=Math.max(ans,i-map.get(sum));
            else
                map.put(sum,i);
        }
        return ans;
    }
}

// APPROACH
//The question simplifies to taking the difference array of a1 and a2 and find the longest 
// subarray with sum zero in it.

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(n)