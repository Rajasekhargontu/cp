import java.util.HashMap;

class Solution {
    public long subarrayXor(int arr[], int k) {
        int cnt=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int xor=0;
        for(int i:arr){
            xor=xor^i;
            cnt+=map.getOrDefault(k^xor,0);
            map.put(xor,map.getOrDefault(xor,0)+1);
        }
        return cnt;
    }
}

// APPROACH
// We take cumulative xor for each prefix and store it along with frequency of its occurence
// Whenever we get a prefix xor of p we increment the cnt by frequency of (k^p) present in map
// Add the cnt over all indexes and return it

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(n)