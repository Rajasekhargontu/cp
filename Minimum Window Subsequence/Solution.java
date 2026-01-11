class Solution {
    public String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        String ans = "";
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // find starting point where s1[i] matches s2[0]
            if (s1.charAt(i) == s2.charAt(0)) {
                int p1 = i, p2 = 0;
                // move forward until s2 is matched
                while (p1 < n && p2 < m) {
                    if (s1.charAt(p1) == s2.charAt(p2)) p2++;
                    p1++;
                }
                // if we matched all characters of s2
                if (p2 == m) {
                    int len = p1 - i-1;
                    if (len < minLen) {
                        minLen = len;
                        ans = s1.substring(i, p1);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(minWindow("abcdebdde","bde"));
        System.out.println(minWindow("ad","b"));
    }
}

// APPROACH
// 1. Assume each index as the starting point of substring
// 2. If the characters match then we try to find the substring containing whole of s2 as subsequence
// 3. If we were able to find a match then we update the length and answer
// 4. return the answer.