class Solution {
    int maxSum(int[] arr) {
        int sum=0,n=arr.length,total=arr[0];
        for(int i=1;i<n;i++){
            sum+=(i*arr[i]);
            total+=arr[i];
        }
        int res=sum;
        for(int i=1;i<n;i++){
            sum=sum+arr[i-1]*(n)-total;
            res=Math.max(res,sum);
        }
        return res;
    }
}

// APPROACH
// First compute the sum with the given array
// Then traverse each index and assume that if its the 0th index then my sum will be modified as:
//    sum=sum+arr[i-1]*(n)-totalSum
// Take the maximum of all possible sums

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(1)