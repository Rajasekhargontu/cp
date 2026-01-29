class Solution {
    public String firstNonRepeating(String s) {
        int[] freq=new int[26];
        StringBuilder sb=new StringBuilder();
        int left=0,right=0;
        while(right<s.length()){
            char ch=s.charAt(right);
            freq[ch-'a']++;
            while(left<s.length() && freq[s.charAt(left)-'a']>1) left++;
            if(left<=right) sb.append(s.charAt(left));
            else sb.append("#");
            right++;
        }
        return sb.toString();
    }
}
// APPROACH
// Maintain an array storing the frequencies of every character
// We use two pointer approch where the left pointer is present at the character which is not repeated
// If the left>right meaning we have no chracter in left that is not repeated so add "#" else add character at left
// return the result as a string

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(1)