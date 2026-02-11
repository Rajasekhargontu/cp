class Solution {
    public int minCost(int[] heights, int[] cost) {
        int l = Integer.MAX_VALUE, h = 0;
        for (int i : heights) {
            l = Math.min(l, i);
            h = Math.max(h, i);
        }
        long ans = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            long midCost = cost(heights, cost, mid);
            long nextCost = cost(heights, cost, mid + 1);
            if (midCost > nextCost) {
                l = mid + 1;
                ans = nextCost;
            } else {
                h = mid - 1;
                ans = midCost;
            }
        }
        return (int) ans;
    }

    public long cost(int[] heights, int[] cost, int k) {
        long ans = 0;
        for (int i = 0; i < heights.length; i++) {
            ans += (long) Math.abs(heights[i] - k) * cost[i];
        }
        return ans;
    }
}


// APPROACH
// The costs are not strictly increasing or decreasing the first decrease and then increase forming a V shaped curve
// The limits of the equalized heights will be between the minimum and maximum heights given
// To perform binary search we at each iteration compute the cost with current and next Heights so as to decide whichpart to discard
// If we are on decreasing side then we discard left part else discard the right part 
// Save the ans aat each iteration and return the final ans

// COMPLEXITIES
// TIME : O(n * log(max(heights[i]) - min(heights[i]))
// SPACE : O(1)