class Solution {
    public int getCount(int n, int d) {
        int low=0,high=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(mid,d)) high=mid-1;
            else low=mid+1;
        }
        return n-high;
    }
    public boolean isValid(int n,int d){
        int sum=0;
        int k=n;
        while(k>0){
            sum+=k%10;
            k=k/10;
        }
        return n-sum>=d;
    }
};

// APPROACH
// We need to find the smallest number that satisfy the given condiions
// To do this we use the Binary Search technique over the range [0,n]
// We find the first value where the condition holds and then return the length of the right part as the answer

// COMPLEXITIES
// TIME : O(log n)
// SPACE : O(1)