class Solution {
    public static String minWindow(String s, String p) {
        int[] map1=new int[26];
        int[] map2=new int[26];
        int len=Integer.MAX_VALUE,start=0;
        for(char ch:p.toCharArray()){
            map1[ch-'a']++;
        }
        int left=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map2[ch-'a']++;
            while(left<=i){
                char chr=s.charAt(left);
                if(map1[chr-'a']==0) left++;
                else if(map1[chr-'a']< map2[chr-'a']){
                    map2[chr-'a']--;
                    left++;
                }
                else break;
            }
            boolean equal=true;
            for(int k=0;k<26;k++){
                if(map1[k]!=0 && map2[k] < map1[k]){
                    equal=false;
                    break;
                }
            }
            if(equal && len > i-left+1){
                    len=i-left+1;
                    start=left;
            }
        }
        return len==Integer.MAX_VALUE ? "": s.substring(start,start+len);
    }
}

// APPROACH
// Create two maps one stores the frequency of each character in P and other stores frequency of each character in the current substring.
// We go on increasing the size of the current substring until the frequency is within the required limit otherwise go on decreasing the frequencies from left to right.


// COMPLEXITIES
// TIME : O(n)
// SPACE : O(1)