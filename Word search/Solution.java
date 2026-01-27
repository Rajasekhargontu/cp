class Solution {
    String match;
    char[][] grid;
    public boolean isWordExist(char[][] mat, String word) {
        match=word;
        grid=mat;
        int m=mat.length,n=mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(exists(i,j,0)) return true;
            }
        }
        return false;
    }
    public boolean exists(int r,int c,int idx){
        if(idx==match.length()) return true;
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || match.charAt(idx)!=grid[r][c]) return false;
        char ch=grid[r][c];
        grid[r][c]='*';
        boolean ans=false;
        ans = ans|| exists(r+1,c,idx+1);
        ans = ans|| exists(r,c+1,idx+1);
        ans = ans ||exists(r-1,c,idx+1);
        ans = ans || exists(r,c-1,idx+1);
        grid[r][c]=ch;
        return ans;
    }
}
// APPROACH
// Just backtrack from every index in the matrix

// COMPLEXITIES
// TIME : O(n*m* 4 ^ word.length) 
// SPACE : O(word.length) due to recursion stack;