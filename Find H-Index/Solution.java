class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n)
                freq[n] += 1;
            else
                freq[citations[i]] += 1;
        }
        int idx = n;
        int s = freq[n]; 
        while (s < idx) {
            idx--;
            s += freq[idx];
        }
        return idx;
    }
}

// APPROACH
// Here If we observe the maximum H-index that can be possible is within the range of length of citations.
// Because we cannot satisfy the constraint that there should be more at least n papers with citation>=n in an array of size n.
// We initialize an array to store frequencies of each element and if its greater than citations size we add it to buffer space.
// We traverse from left to right and find the suitable index satifying the conditions and return it.

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(n)