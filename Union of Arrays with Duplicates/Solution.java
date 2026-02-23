import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:a) set.add(i);
        for(int i:b) set.add(i);
        return new ArrayList<Integer>(set);
    }
}
// APPROACH
// Add numbers in both arrays into a HashSet and return the list of values in the HashSet as ArrayList

// COMPLEXITIES
// TIME : O(n+m)
// SPACE : O(n+m)