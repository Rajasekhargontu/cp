import java.util.*;
class Solution {
    // stores permutations
    static ArrayList<ArrayList<Integer>> ans;
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ans=new ArrayList<>();
        // Ensures that the permutations are generated in sorted order
        Arrays.sort(arr);
        // stores.current permutation
        ArrayList<Integer> curr=new ArrayList<>();
        // Used to check whether the element is used in permutation or not without removing
        boolean[] taken=new boolean[arr.length];
        generatePermutations(arr,curr,taken);
        return ans;
    }
    // Recursivefunction to generate all permutations
    public static void generatePermutations(int[] arr,ArrayList<Integer> curr,boolean[] taken){
        // If all the elements are included we add it to the ans
        if(curr.size()==arr.length){
            ans.add(new ArrayList<>(curr));
        }
        // Iterate over all numbers and select one at a time 
        for(int i=0;i<taken.length;i++){
            if(!taken[i]){
                taken[i]=true;
                // Take an element and generate all permutations
                curr.add(arr[i]);
                generatePermutations(arr,curr,taken);
                // reset the choosen element
                taken[i]=false;
                curr.remove(curr.size()-1);
            }
        }
    }
};

// COMPLEXITIES
// TIME : O(n!)
// SPACE : O(n)