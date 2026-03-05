class Solution {
    public int longestKSubstr(String s, int k) {
        int[] freq=new int[26];
        int left=0,dc=0,ans=-1,right=0;
        for(char ch:s.toCharArray()){
            if(freq[ch-'a']==0) dc++;
            freq[ch-'a']++;
            while(dc>k){
                char x=s.charAt(left);
                if(freq[x-'a']==1) dc--;
                freq[x-'a']--;
                left++;
            }
            right++;
            if(dc==k)
            ans=Math.max(ans,right-left);
        }
        return ans;
    }
}

// APPROACH
// Here we keep track of frequency of occurence of each character along with no of distinct characters
// Whenever the no of distinct characters becomes k we take the maximum of the existing answer and current answer.

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(1)