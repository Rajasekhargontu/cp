class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        int ans=0;
        for(int i:left) ans=Math.max(ans,i);
        for(int i:right) ans=Math.max(ans,n-i);
        return ans;
    }
}

// APPROACH
// If two ants collide they change their directions so we can say that we collision occurs
// the distance they need to travel just gets exchanged.
// So we can directly find the actual distance they need to travel before reaching the end of plank.
// Find the maximum such value for any of the given ants.

// COMPLEXITIES
// TIME : O(m+n)
// SPACE : O(1)