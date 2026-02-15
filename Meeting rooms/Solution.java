import java.util.Arrays;

class Solution {
    static boolean canAttend(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]<arr[i-1][1]) return false;
        }
        return true;
    }
}

// APPROACH
// First Sort the intervals based on start time.
// Then check whether there is a overlap in any two adjacent intervals.
// If so return false; else return true;

// COMPLEXITIES
// TIME : O(n log n)
// SPACE : O(n)