class Solution {
    public int totalElements(int[] arr) {
        int left = 0, right = 0, ans = 0;
        int[] vals = new int[2];
        int[] freq = new int[2];
        while (right < arr.length) {
            if (vals[0] == arr[right])
                freq[0]++;
            else if (vals[1] == arr[right])
                freq[1]++;
            else {
                while (freq[0] != 0 && freq[1] != 0) {
                    if (vals[0] == arr[left])
                        freq[0]--;
                    else
                        freq[1]--;
                    left++;
                }
                if (freq[0] == 0) {
                    vals[0] = arr[right];
                    freq[0] = 1;
                } else {
                    vals[1] = arr[right];
                    freq[1] = 1;
                }
            }
            ans = Math.max(ans, freq[0] + freq[1]);
            right++;
        }
        return ans;
    }
}

// APPROACH
// We use 2-pointer approach here.
// While moving the right pointer we check if there are atmost 2 distinct integers or not
// If not we just move the left pointer until the condition is satisfied.
// Take the maximum of all such subarray lengths i.e. right-left

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(1)