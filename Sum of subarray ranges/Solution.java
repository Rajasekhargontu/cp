import java.util.*;
class Solution {
    public int subarrayRanges(int[] arr) {
        int n=arr.length;
        // Stores the next index where the value is greater than the current element
        int[] nger=new int[n];
        // stores the previous index where the value is greater then current element
        int[] ngel=new int[n];
        // stores the previous index where value is samaaler than current index
        int[] nsel=new int[n];
        // stores the next index where the value is less than current element
        int[] nser=new int[n];
        Arrays.fill(nsel,-1);
        Arrays.fill(nser,n);
        Arrays.fill(ngel,-1);
        Arrays.fill(nger,n);
        // Use it with monotonicity property to fill the arrays
        Stack<Integer> stack=new Stack<>();
        // Next greatest element to the left
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]) stack.pop();
            if(!stack.isEmpty()) ngel[i]=stack.peek();
            stack.push(i);
        }
        stack.clear();
        // Next greatest element to the right
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) stack.pop();
            if(!stack.isEmpty()) nger[i]=stack.peek();
            stack.push(i);
        }
        stack.clear();
        // Next smallest element to the left
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) stack.pop();
            if(!stack.isEmpty()) nsel[i]=stack.peek();
            stack.push(i);
        }
        stack.clear();
        // Next smallest element to the right
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) stack.pop();
            if(!stack.isEmpty()) nser[i]=stack.peek();
            stack.push(i);
        }
        long ans=0;
        for (int i = 0; i < n; i++) {
            // count of subarrays where arr[i] is maximum
            long maxCount = (long)(i - ngel[i]) * (nger[i] - i);
            // count of subarrays where arr[i] is minumim
            long minCount = (long)(i - nsel[i]) * (nser[i] - i);
            ans += (maxCount - minCount) * arr[i];
        }
        return (int)ans;
    }
}
// APPROACH
// First fill the 4 arrays as required
// Next for every index find the no of subarrays where the current element is maximum ad add its score 
// subtract from the score the score due to the arr[i] being the smallest element in the subarrays

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(n)
