import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
       HashSet<Integer> set=new HashSet<>();
       for(int i:arr){
           if(i>=low && i<=high) set.add(i);
       }
       ArrayList<Integer> ans=new ArrayList<>();
       for(int i=low;i<=high;i++){
           if(!set.contains(i)) ans.add(i);
       }
       return  ans;
    }
}

// APPROACH
// First add all elements in the range of [low,high] in a set.
// Iterate in the range [low,high] and if any number is not found in the set add it to answer.
// return the list of such numbers.

// COMPLEXITIES:
// TIME : O(n + high - low)
// SPACE : O(n)