import java.util.*;
class Solution {
    public int minCandy(int[] arr) {
        int n = arr.length;
        // Stores no of candies allotted to each student
        int[] candies = new int[n];
        // Make sure each student get one candy
        Arrays.fill(candies,1);
        // Do a forward pass and adjust candies
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // Do a reverse pass and check if we can minimize any allotment
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int ans = 0;
        for (int c : candies) {
            ans += c;
        }
        // Sum up all the alloted candies and return
        return ans;
    }
}

// APPROACH
// This is a greedy style problem where we need to minimize the no of candies to distribute based on given conditions
// We can solve this problem using a Two pass simulation over the array
// In the first pass we find what is the no of candies a child can get if we go in the forward direction
// In the reverse pass we try to reduce the number of candies needed by giving the  candidate just 1 more than what is needed to satisfy conditions
// Finally we sum up all the candies and return them


//COMPLEXITIES
// TIME: O(n)
// SPACE: O(n) --> CAN BE OPTIMISED TO O(1)
