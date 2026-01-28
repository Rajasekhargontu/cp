import java.util.*;
class Solution {
    HashMap<Integer,Integer> hash1,hash2;
    int[] vals;
    int target;
    public int countSubset(int[] arr, int k) {
        vals=arr;
        target=k;
        hash1=new HashMap<>();
        hash2=new HashMap<>();
        // Find the no of subsets in both halves
        count(vals.length/2,0,0,hash1);
        count(vals.length,vals.length/2,0,hash2);
        int  ans=0;
        // find each sum in left half count the no of complementing parts in right half
        for(int i:hash1.keySet()){
                int n1=hash1.get(i);
                int n2=hash2.getOrDefault(k-i,0);
                ans+=(n1*n2);
        }
        return ans;
        
    }
    // Recursive function to find all possible subset sums
    public void count(int h,int idx,int sum,HashMap<Integer,Integer> hash){
        if(idx==h){
            hash.put(sum,hash.getOrDefault(sum,0)+1);
            return;
        }
        count(h,idx+1,sum+vals[idx],hash);
        count(h,idx+1,sum,hash);
        
    }
}

// COMPLEXITIES
// TIME : O(2^(n/2))
// SPACE : O(n)