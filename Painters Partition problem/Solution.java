class Solution {
    public int minTime(int[] arr, int k) {
        int low=1,high=0;
        for(int i:arr){
            high+=i;
            low=Math.max(low,i);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int painters=getPainters(arr,mid);
            if(painters>k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    public int getPainters(int[] arr,int max){
        int sum=0,cnt=0;
        for(int i:arr){
            if(sum+i <=max){
                sum+=i;
            }
            else{
                sum=i;
                cnt++;
            }
        }
        cnt++;
        return cnt;
    }
}

// APPROACH
// We use binary search on answers approach to solve this problem.
// BS is applied on the range [ max(arr), sum(arr) ]
// In each iteration we select Mid and find out if my mid element is maximum units required then how many painters i'm gonna need
// if we need painters <= k we can minimize Units hence high= mid-1;
// else we need to extend the maximum units one paint so low=mid+1;
// return low

// COMPLEXITIES
// TIME : O(n log (sum(arr)-max(arr)))
// SPACE : O(1)
