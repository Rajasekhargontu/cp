import java.util.Arrays;

class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        char[] map1=new char[26];
        Arrays.fill(map1,'*');
        boolean[] mapped=new boolean[26];
        for(int i=0;i<s1.length();i++){
            char c1=s1.charAt(i),c2=s2.charAt(i);
            if(mapped[c2-'a'] && map1[c1-'a']==c2) continue;
            else if(!mapped[c2-'a'] && map1[c1-'a']=='*'){
                mapped[c2-'a']=true;
                map1[c1-'a']=c2;
            }
            else return false;
        }
        return true;
    }
}

// APPROACH
// Use two arrays 0f size 26 - one for storing which character is mapped to what and the other
// for storing what are the characters are mapped.
// If we encounter a new pair add it to the arrays
// If a new mapping for the already mapped ones arrives return false; otherwise return true

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(1)