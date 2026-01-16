import java.util.*;
class Solution {
    public int minMen(int[] arr) {
        int n = arr.length;
        ArrayList<int[]> intervals = new ArrayList<>();
        //Build intervals
        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) continue;
            int start = Math.max(0, i - arr[i]);
            int end = Math.min(n - 1, i + arr[i]);
            intervals.add(new int[]{start, end});
        }
        if (intervals.isEmpty()) return -1;
        //Sort intervals
        Collections.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });
        //Greedy interval covering
        int taken = 0;
        int coveredTill = -1;
        int idx = 0;
        while (coveredTill < n - 1) {
            int farthest = coveredTill;
            // extend coverage as far as possible
            while (idx < intervals.size() &&
                   intervals.get(idx)[0] <= coveredTill + 1) {
                farthest = Math.max(farthest, intervals.get(idx)[1]);
                idx++;
            }
            // if coverage can't be extended
            if (farthest == coveredTill) return -1;
            taken++;
            coveredTill = farthest;
        }
        return taken;
    }
}


// APPROACH
// First generate the intervals based on the give conditions like [start, end] for every worker
// The goal is to select minimum intervals so that we can get all values in the range 0 to n-1
// We sort the intervals by their start index and then by end index
// We take each interval one by one
// -- when we select one and on the other iterations we try to findout the maximum forward we can move
// by any interval which have a starting in the range of [si_start+1,s1_end+1]
// --If we were unable to find one such index we return -1 as the intervals become non contiguous.
// --else we update the counter and select the latest far point as curr_reached and continue the previous step.


// COMPLEXITIES
// TIME: O(n log n) -- DUE TO SORTING
// SPACE: O(n) -- DUE TO STORING INTERVALS
